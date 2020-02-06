

package com.codeabovelab.dm.cluman.security;

import com.codeabovelab.dm.common.security.MultiTenancySupport;
import com.codeabovelab.dm.common.security.Tenant;
import com.codeabovelab.dm.common.security.acl.TenantsService;

import java.util.Collections;
import java.util.List;

/**
 * Temporary stub implementation for tenant service.
 */
public class StubTenantsService extends TenantsService<Tenant> {

    @Override
    public boolean isRoot(String tenant) {
        return MultiTenancySupport.ROOT_TENANT.equals(tenant);
    }

    @Override
    protected Tenant getTenant(String tenant) {
        return () -> tenant;
    }

    @Override
    protected List<Tenant> getChilds(Tenant tenant) {
        return Collections.emptyList();
    }
}
