

package com.codeabovelab.dm.common.security.acl;

import java.util.Collection;

/**
 * service which provide mapping between tenant -> childTenants
 */
public interface TenantsHierarchyFunction {
    
    /**
     * add to specified collection child tenants
     * @param tenantId
     * @param childTenants target collection in which will be added child tenants
     */
    void getChildTenants(Long tenantId, Collection<Long> childTenants);
}
