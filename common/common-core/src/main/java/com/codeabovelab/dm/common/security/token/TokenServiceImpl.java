

package com.codeabovelab.dm.common.security.token;


/**
 * Default implementation of token service.
 */
public class TokenServiceImpl implements TokenService {

    private TokenService backend;

    public TokenService getBackend() {
        return backend;
    }

    public void setBackend(TokenService backend) {
        this.backend = backend;
    }

    @Override
    public TokenData createToken(TokenConfiguration config) {
        return this.backend.createToken(config);
    }

    @Override
    public TokenData getToken(String token) {
        return this.backend.getToken(token);
    }

    @Override
    public void removeToken(String token) {
        this.backend.removeToken(token);
    }

    @Override
    public void removeUserTokens(String userName) {
        backend.removeUserTokens(userName);
    }

}
