

package com.codeabovelab.dm.common.gateway;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Simple implementation of server text messages.
 * @see ClientConnection#send(Object)
 */
@Data
public final class TextMessageImpl implements TextMessage {
    private final String title;
    private final String message;

    @JsonCreator
    public TextMessageImpl(@JsonProperty("title")   String title,
                           @JsonProperty("message") String message) {
        this.title = title;
        this.message = message;
    }

}
