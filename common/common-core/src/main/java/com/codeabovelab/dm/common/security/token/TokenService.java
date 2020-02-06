

package com.codeabovelab.dm.common.security.token;

/**
 * Service which manages tokens.
 * Token can be identified by it {@link TokenData#getKey()} value.
 */
public interface TokenService {
    /**
     * Create and persist new token.
     * @param config
     * @return
     */
    TokenData createToken(TokenConfiguration config);

    /**
     * Get specified token if it exists and valid (expiration not checked there).
     * If token not valid then throw exception.
     * @param token
     * @return
     */
    TokenData getToken(String token) throws TokenException;

    /**
     * Remove specified token.
     * @param token
     */
    void removeToken(String token);

    /**
     * Remove all user tokens.
     * @param userName
     */
    void removeUserTokens(String userName);
}
