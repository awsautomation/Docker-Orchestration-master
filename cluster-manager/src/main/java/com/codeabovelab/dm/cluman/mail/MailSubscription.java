
package com.codeabovelab.dm.cluman.mail;

import com.codeabovelab.dm.cluman.model.Severity;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Topic and email is a key
 */
@Data
public class MailSubscription {

    @Data
    public static class Builder {
        private String eventSource;
        private Severity severity;
        private String title;
        private String user;
        private String template;

        public Builder from(MailSubscription subs) {
            setEventSource(subs.getEventSource());
            setSeverity(subs.getSeverity());
            setTitle(subs.getTitle());
            setTemplate(subs.getTemplate());
            setUser(subs.getUser());
            return this;
        }

        public Builder user(String emailRecipient) {
            setUser(emailRecipient);
            return this;
        }

        public Builder severity(Severity severity) {
            setSeverity(severity);
            return this;
        }

        public Builder eventSource(String eventSource) {
            setEventSource(eventSource);
            return this;
        }

        public MailSubscription build() {
            return new MailSubscription(this);
        }
    }

    @NotNull
    private final String eventSource;
    @NotNull
    private final Severity severity;
    @ApiParam("Pass null for using default")
    private final String title;
    @NotNull
    private final String user;
    @ApiParam("Pass null for using default")
    private final String template;
    private final String id;

    @JsonCreator
    public MailSubscription(Builder b) {
        this.eventSource = b.eventSource;
        this.severity = b.severity;
        this.title = b.title;
        this.user = b.user;
        this.template = b.template;
        this.id = this.user + ":" + b.getEventSource();
    }

    public static Builder builder() {
        return new Builder();
    }
}
