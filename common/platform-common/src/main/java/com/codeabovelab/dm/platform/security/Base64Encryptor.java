
package com.codeabovelab.dm.platform.security;

import org.springframework.security.crypto.encrypt.BytesEncryptor;
import org.springframework.security.crypto.encrypt.TextEncryptor;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Base64 warpper on {@link BytesEncryptor }
 */
public class Base64Encryptor implements TextEncryptor {
    private final BytesEncryptor encryptor;

    public Base64Encryptor(BytesEncryptor encryptor) {
        this.encryptor = encryptor;
    }

    @Override
    public String encrypt(String text) {
        byte[] encrypt = encryptor.encrypt(text.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encrypt);
    }

    @Override
    public String decrypt(String encryptedText) {
        byte[] decode = Base64.getDecoder().decode(encryptedText);
        return new String(encryptor.decrypt(decode), StandardCharsets.UTF_8);
    }
}
