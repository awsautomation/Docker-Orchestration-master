
package com.codeabovelab.dm.cluman.security;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 */
public interface AuthoritiesService {
    Collection<GrantedAuthority> getAuthorities();
}
