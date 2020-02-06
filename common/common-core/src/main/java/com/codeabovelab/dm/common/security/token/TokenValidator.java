

package com.codeabovelab.dm.common.security.token;

/**
 * Token verification service
 */
public interface TokenValidator {

    TokenData verifyToken(String token, String deviceHash) throws TokenException;

    TokenData verifyToken(String token) throws TokenException;

}
