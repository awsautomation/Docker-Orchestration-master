
package com.codeabovelab.dm.cluman.ui.model;

import com.codeabovelab.dm.common.security.acl.TenantSid;
import com.codeabovelab.dm.common.security.dto.PermissionData;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 */
@Data
public class UiAclUpdate {

    @Data
    public static class UiAceUpdate {
        protected boolean delete = false;
        protected String id;
        protected TenantSid sid;
        protected Boolean granting;
        protected PermissionData permission;
        protected Boolean auditFailure;
        protected Boolean auditSuccess;
    }

    private final List<UiAceUpdate> entries = new ArrayList<>();
    private TenantSid owner;
}
