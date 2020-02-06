

package com.codeabovelab.dm.common.security;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;

/**
 * Service which allow us to load user by name, or by its identifiers.
 */
public interface UserIdentifiersDetailsService extends UserDetailsService {

    Collection<ExtendedUserDetails> getUsers();

    ExtendedUserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    /**
     *
     * @param identifiers
     * @throws UsernameNotFoundException if the user could not be found or the user has no
     * GrantedAuthority
     * @return user details
     */
    ExtendedUserDetails loadUserByIdentifiers(UserIdentifiers identifiers);
}
