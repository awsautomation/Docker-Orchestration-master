

package com.codeabovelab.dm.common.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Process authentication for user. Can be used, for example to inject granted authorities.
 */
public interface SuccessAuthProcessor {
    /**
     * @see SecurityUtils#createSuccessAuthentication(Authentication, UserDetails)
     * @param source
     * @param userDetails
     * @return
     */
    Authentication createSuccessAuth(Authentication source, UserDetails userDetails);
}
