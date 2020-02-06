

package com.codeabovelab.dm.common.security.acl;

import com.codeabovelab.dm.common.security.Authorities;
import com.codeabovelab.dm.common.security.MultiTenancySupport;
import com.codeabovelab.dm.common.security.dto.PermissionData;
import org.springframework.security.acls.domain.GrantedAuthoritySid;
import org.springframework.security.acls.model.Sid;

/**
 * implementation of PermissionGrantingJudge which provide defaultBehavior for strategy
 */
public class PermissionGrantingJudgeDefaultBehavior implements PermissionGrantingJudge {

    private final TenantsService tenantsService;

    public PermissionGrantingJudgeDefaultBehavior(TenantsService tenantsService) {
        this.tenantsService = tenantsService;
    }

    @Override
    public PermissionData getPermission(PermissionGrantingContext context) {
        PermissionData.Builder pdb = PermissionData.builder();
        final Sid currSid = context.getCurrentSid();
        //by ADMIN authority
        if(currSid instanceof GrantedAuthoritySid && Authorities.ADMIN_ROLE.equals(((GrantedAuthoritySid)currSid).getGrantedAuthority())) {
            final String tenantId = MultiTenancySupport.getTenant(currSid);
           
            if(isRootTenant(tenantId) ||
                (tenantId != MultiTenancySupport.NO_TENANT?
                tenantId.equals(context.getOwnerTenant()) :
                context.getCurrentTenants().contains(context.getOwnerTenant()))) {
                pdb.add(PermissionData.ALL);
            }
        }
        if(PermissionData.ALL.getMask() != pdb.getMask()) {
            if(isAllowByOwner(context)) {
                pdb.add(PermissionData.ALL);
            }
        }

        return pdb.build();
    }

    private boolean isRootTenant(String tenant) {
        return tenantsService.isRoot(tenant);
    }

    private boolean isAllowByTenant(PermissionGrantingContext context) {
        // if SID owned by 'ownerTenantId' or it supertenants then he can read
        return context.getCurrentTenants().contains(context.getOwnerTenant());
    }

    private boolean isAllowByOwner(PermissionGrantingContext context) {
        // if is owner then allow all permissions
        return context.getOwnerSid().equals(context.getCurrentSid());
    }
}
