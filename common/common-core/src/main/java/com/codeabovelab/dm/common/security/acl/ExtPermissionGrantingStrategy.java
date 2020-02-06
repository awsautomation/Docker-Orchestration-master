

package com.codeabovelab.dm.common.security.acl;

import com.codeabovelab.dm.common.security.dto.PermissionData;
import org.springframework.security.acls.model.Acl;
import org.springframework.security.acls.model.PermissionGrantingStrategy;
import org.springframework.security.acls.model.Sid;

import java.util.List;

/**
 */
public interface ExtPermissionGrantingStrategy extends PermissionGrantingStrategy {
    /**
     * Collecting ACE entries and default permissions to single permission fo specified sids.
     * @param acl
     * @param sids
     * @return collected permission
     */
    PermissionData getPermission(Acl acl, List<Sid> sids);
}
