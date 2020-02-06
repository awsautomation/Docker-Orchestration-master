

package com.codeabovelab.dm.common.security.acl;

import com.codeabovelab.dm.common.security.dto.PermissionData;

public interface PermissionGrantingJudge {
    PermissionData getPermission(PermissionGrantingContext context);
}
