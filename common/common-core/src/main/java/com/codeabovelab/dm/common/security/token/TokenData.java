

package com.codeabovelab.dm.common.security.token;

/**
 * The representation of token.
 */
public interface TokenData {
    String getUserName();
    String getDeviceHash();

    /**
     * type of token, we can support many types of token.
     * @see com.codeabovelab.dm.platform.users.token.TokenUtils#getTypeFromKey(String)
     * @return
     */
    String getType();

    String getKey();

    long getCreationTime();
}
