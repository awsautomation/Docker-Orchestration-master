

package com.codeabovelab.dm.common.security;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.GrantedAuthority;

/**
 */
public interface TenantGrantedAuthority extends GrantedAuthority, OwnedByTenant, ConfigAttribute {
}
