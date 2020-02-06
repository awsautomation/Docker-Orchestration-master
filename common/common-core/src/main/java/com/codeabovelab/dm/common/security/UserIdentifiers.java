

package com.codeabovelab.dm.common.security;

/**
 * Common iface for object contains unique user identifiers. <p/>
 * @see com.codeabovelab.dm.common.security.SecurityUtils#validate(UserIdentifiers)
 */
public interface UserIdentifiers {

    /**
     * username aka login
     * @return
     */
    String getUsername();

    /**
     * User email
     * @return
     */
    String getEmail();
}
