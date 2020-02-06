

package com.codeabovelab.dm.common.security.dto;

import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

/**
 * The DTO for group of authorities.
 */
public interface AuthorityGroupData extends AuthorityGroupId {

    Set<GrantedAuthority> getAuthorities();

}
