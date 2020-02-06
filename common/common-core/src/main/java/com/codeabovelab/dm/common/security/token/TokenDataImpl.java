

package com.codeabovelab.dm.common.security.token;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Objects;

/**
 * An signed token implementation.
 */
@Data
public class TokenDataImpl implements TokenData {
    private final String userName;
    private final String key;
    private final String deviceHash;
    private final long creationTime;

    @JsonCreator
    public TokenDataImpl(@JsonProperty("creationTime") long creationTime,
                         @JsonProperty("key") String key,
                         @JsonProperty("userName") String userName,
                         @JsonProperty("deviceHash") String deviceHash) {
        this.creationTime = creationTime;
        this.key = key;
        this.userName = userName;
        this.deviceHash = deviceHash;
    }

    @Override
    public String getType() {
        return TokenUtils.getTypeFromKey(key);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TokenDataImpl tokenData = (TokenDataImpl) o;
        return Objects.equals(key, tokenData.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }

}
