
package com.codeabovelab.dm.cluman.security;

import com.codeabovelab.dm.common.security.acl.AclSource;
import org.springframework.security.acls.model.ObjectIdentity;

/**
 */
public interface WithAcl {
    ObjectIdentity getOid();

    AclSource getAcl();

    /**
     * Do not place time consumption ops here.
     * @param operator
     */
    void updateAcl(AclModifier operator);
}
