

package com.codeabovelab.dm.common.security;

import com.codeabovelab.dm.common.security.dto.AuthenticationData;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

/**
 */
public class SecurityUtils {

    public static final ExtendedUserDetails USER_ANONYMOUS = ExtendedUserDetailsImpl.builder()
      .title("Anonymous")
      .username("anonymous")
      .tenant(MultiTenancySupport.ANONYMOUS_TENANT)
      .build();
    public static final ExtendedUserDetails USER_SYSTEM = ExtendedUserDetailsImpl.builder()
      .title("System")
      .username("system")
      .tenant(MultiTenancySupport.ROOT_TENANT)
      .accountNonLocked(false)
      .addAuthority(Authorities.ADMIN)
      .build();
    public static final Authentication AUTH_SYSTEM = AuthenticationData.build()
      .authenticated(true)
      .authorities(USER_SYSTEM.getAuthorities())
      .principal(USER_SYSTEM)
      .name(USER_SYSTEM.getUsername())
      .build();

    /**
     * Validate {@link com.codeabovelab.dm.common.security.UserIdentifiers} object. <p/>
     * It check that object contains al least one non null identity value.
     *
     * @param ui
     */
    public static void validate(UserIdentifiers ui) {
        if (!StringUtils.hasText(ui.getUsername()) &&
          !StringUtils.hasText(ui.getEmail())
          ) {
            throw new RuntimeException(ui.getClass().getSimpleName() + " must construct with at least one of non null fields!");
        }
    }

    public static void copyIdentifiers(UserIdentifiers from, MutableUserIdentifiers to) {
        to.setEmail(from.getEmail());
        to.setUsername(from.getUsername());
    }

    /**
     * Set auth details if it possible
     * @param authentication
     * @param details
     * @return  true if update details is success
     */
    public static boolean setDetailsIfPossible(Authentication authentication, Object details) {
        if(authentication instanceof AbstractAuthenticationToken) {
            ((AbstractAuthenticationToken)authentication).setDetails(details);
            return true;
        }
        return false;
    }

    /**
     * Create success credentials from source credentials and user details.
     * @param source
     * @param userDetails
     * @return
     */
    public static Authentication createSuccessAuthentication(Authentication source, UserDetails userDetails) {
        final UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(
          userDetails, userDetails.getPassword(), userDetails.getAuthorities());
        result.setDetails(source.getDetails());
        return result;
    }
}
