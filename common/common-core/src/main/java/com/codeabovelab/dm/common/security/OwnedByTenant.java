

package com.codeabovelab.dm.common.security;

/**
 * any domain object which owned by tenant
 */
public interface OwnedByTenant {
    /**
     * an tenant unique identifier
     * @return 
     */
    String getTenant();
}
