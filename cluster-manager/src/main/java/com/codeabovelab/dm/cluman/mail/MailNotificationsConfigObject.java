
package com.codeabovelab.dm.cluman.mail;

import lombok.Data;

import java.util.List;

@Data
public class MailNotificationsConfigObject {
    private List<MailSubscription> subscriptions;
}
