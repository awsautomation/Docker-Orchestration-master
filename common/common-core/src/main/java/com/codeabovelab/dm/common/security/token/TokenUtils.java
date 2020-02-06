

package com.codeabovelab.dm.common.security.token;

/**
 * Utilites for token.
 */
public final class TokenUtils {
    public static String getTypeFromKey(String key) {
        if(key == null || key.isEmpty()) {
            throw new TokenException("Token is null or empty");
        }
        int i = key.indexOf(":");
        return key.substring(0, i);
    }

    public static String getTokenFromKey(String key) {
        if(key == null || key.isEmpty()) {
            throw new TokenException("Token is null or empty");
        }
        int i = key.indexOf(":");
        return key.substring(i + 1);
    }

    public static String getKeyWithTypeAndToken(String type, String token) {
        return type + ":" + token;
    }
}
