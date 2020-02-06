

package com.codeabovelab.dm.common.security.dto;

import org.springframework.security.acls.model.Permission;
import org.springframework.security.acls.model.Sid;

import java.io.Serializable;

/**
 * ACE DTO iface <p/>
 * TODO add version info for CAS-like resolving of concurrent  modification problem <p/>
 */
public interface AceData extends Serializable {
    Long getId();
    Permission getPermission();
    Sid getSid();
    boolean isGranting();
    boolean isAuditFailure();
    boolean isAuditSuccess();
}
