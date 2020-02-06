

package com.codeabovelab.dm.common.security;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * common iface of extended UserDetails
 *
 */
public interface ExtendedUserDetails extends UserDetails, OwnedByTenant {
    String getTitle();
    String getEmail();
}
