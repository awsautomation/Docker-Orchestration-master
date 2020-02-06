

package com.codeabovelab.dm.common.security;

/**
 * Mutable iface for object contains unique user identifiers. <p/>
 * @see com.codeabovelab.dm.common.security.UserIdentifiers
 */
public interface MutableUserIdentifiers extends UserIdentifiers {

    /**
     * username aka login
     * @return
     */
    void setUsername(String username);

    /**
     * User email
     * @return
     */
    void setEmail(String email);

}
