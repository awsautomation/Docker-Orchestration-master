
package com.codeabovelab.dm.cluman.ds.nodes;

import com.codeabovelab.dm.cluman.security.SecuredType;
import com.codeabovelab.dm.cluman.security.VirtualAclProvider;
import com.codeabovelab.dm.common.security.dto.ObjectIdentityData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.stereotype.Component;

import java.io.Serializable;


@Component("NODE" /*see secured type*/)
public class NodesAclProvider extends VirtualAclProvider {

    @Autowired
    private NodeStorage nodeStorage;

    protected ObjectIdentityData toOid(Serializable id) {
        return SecuredType.NODE.id((String) id);
    }

    @Override
    protected String getCluster(Serializable id) {
        String strId = (String) id;
        NodeRegistrationImpl nr = nodeStorage.getNodeRegistrationInternal(strId);
        if (nr == null) {
            throw new NotFoundException("Node '" + id + "' is not registered.");
        }
        return nr.getCluster();
    }
}
