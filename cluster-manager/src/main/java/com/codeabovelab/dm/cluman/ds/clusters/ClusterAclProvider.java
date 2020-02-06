
package com.codeabovelab.dm.cluman.ds.clusters;

import com.codeabovelab.dm.cluman.model.DiscoveryStorage;
import com.codeabovelab.dm.cluman.model.NodesGroup;
import com.codeabovelab.dm.cluman.security.AclModifier;
import com.codeabovelab.dm.cluman.security.AclProvider;
import com.codeabovelab.dm.common.security.acl.AclSource;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.function.Consumer;

/**
 */
@Component("CLUSTER" /*See SecuredType*/)
public class ClusterAclProvider implements AclProvider {
    // we user ObjectFactory for prevent circular dependency
    private final ObjectFactory<DiscoveryStorage> discoveryStorage;

    @Autowired
    public ClusterAclProvider(ObjectFactory<DiscoveryStorage> discoveryStorage) {
        this.discoveryStorage = discoveryStorage;
    }

    @Override
    public AclSource provide(Serializable id) {
        NodesGroup cluster = getNg(id);
        return cluster.getAcl();
    }


    @Override
    public void update(Serializable id, AclModifier operator) {
        NodesGroup cluster = getNg(id);
        cluster.updateAcl(operator);
    }

    private void checkExistence(NodesGroup cluster, Serializable id) {
        if(cluster == null) {
            throw new NotFoundException("Can not found nodes group for id: " + id);
        }
    }

    @Override
    public void list(Consumer<AclSource> consumer) {
        DiscoveryStorageImpl ds = getDs();
        ds.getClustersBypass(ng -> {
            AclSource acl = ng.getAcl();
            if(acl != null) {
                consumer.accept(acl);
            }
        });
    }

    private NodesGroup getNg(Serializable id) {
        DiscoveryStorageImpl ds = getDs();
        NodesGroup cluster = ds.getClusterBypass((String) id);
        checkExistence(cluster, id);
        return cluster;
    }

    private DiscoveryStorageImpl getDs() {
        return (DiscoveryStorageImpl) discoveryStorage.getObject();
    }
}
