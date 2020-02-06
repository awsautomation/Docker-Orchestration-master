
package com.codeabovelab.dm.cluman.ui.model;

import com.codeabovelab.dm.cluman.mail.MailSubscription;
import com.codeabovelab.dm.cluman.model.Severity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 */
@Data
public class UiUserSubscription {
    @NotNull
    private String eventSource;
    @ApiModelProperty("Default ERROR. Not required on delete.")
    private Severity severity = Severity.ERROR;
    @ApiModelProperty("Default current user.")
    private String user;

    public static UiUserSubscription from(MailSubscription sub) {
        if(sub == null) {
            return null;
        }
        UiUserSubscription ues = new UiUserSubscription();
        ues.setSeverity(sub.getSeverity());
        ues.setEventSource(sub.getEventSource());
        ues.setUser(sub.getUser());
        return ues;
    }
}
