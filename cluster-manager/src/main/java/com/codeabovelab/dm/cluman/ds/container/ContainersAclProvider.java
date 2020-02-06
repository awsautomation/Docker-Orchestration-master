
package com.codeabovelab.dm.cluman.ds.container;

import com.codeabovelab.dm.cluman.ds.nodes.NodeStorage;
import com.codeabovelab.dm.cluman.security.SecuredType;
import com.codeabovelab.dm.cluman.security.VirtualAclProvider;
import com.codeabovelab.dm.cluman.utils.ContainerUtils;
import com.codeabovelab.dm.common.security.dto.ObjectIdentityData;
import lombok.AllArgsConstructor;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component("CONTAINER" /*see secured type*/)
@AllArgsConstructor
public class ContainersAclProvider extends VirtualAclProvider {

    private final ContainerStorage containers;
    private final NodeStorage nodes;

    @Override
    protected String getCluster(Serializable id) {
        String strId = (String) id;
        if(!ContainerUtils.isContainerId(strId)) {
            throw new IllegalArgumentException("Invalid container id: " + id);
        }
        ContainerRegistration cr = containers.getContainer(strId);
        if(cr == null) {
            throw new NotFoundException("Container '" + id + "' is not registered.");
        }
        String node = cr.getNode();
        return nodes.getNodeCluster(node);
    }

    @Override
    protected ObjectIdentityData toOid(Serializable id) {
        return SecuredType.CONTAINER.id((String) id);
    }
}
