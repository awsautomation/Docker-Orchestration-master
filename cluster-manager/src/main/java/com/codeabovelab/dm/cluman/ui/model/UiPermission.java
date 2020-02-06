
package com.codeabovelab.dm.cluman.ui.model;

import com.codeabovelab.dm.cluman.security.AccessContext;
import com.codeabovelab.dm.common.security.acl.AclUtils;
import com.codeabovelab.dm.common.security.dto.ObjectIdentityData;
import com.codeabovelab.dm.common.security.dto.PermissionData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.security.acls.model.ObjectIdentity;

/**
 */
@Data
public class UiPermission {
    /**
     * String with chars from Action.
     * @see com.codeabovelab.dm.common.security.dto.PermissionData#getExpression()
     * @see com.codeabovelab.dm.common.security.Action
     */
    @ApiModelProperty("String expression like 'CRUDEA'")
    private String expr;

    @ApiModelProperty("Secured object identifier, used for manage security data (like ACL) of this object.")
    private String oid;

    public static UiPermission create() {
        return new UiPermission();
    }

    public static UiPermission create(AccessContext ac, ObjectIdentityData oid) {
        UiPermission up = new UiPermission();
        up.oid(oid);
        up.permission(ac.getPermission(oid));
        return up;
    }


    public UiPermission permission(PermissionData permission) {
        setExpr(permission.getExpression());
        return this;
    }

    public UiPermission oid(ObjectIdentity oid) {
        setOid(AclUtils.toId(oid));
        return this;
    }

    public static void inject(WithUiPermission target, AccessContext ac, ObjectIdentityData oid) {
        target.setPermission(UiPermission.create(ac, oid));
    }
}
