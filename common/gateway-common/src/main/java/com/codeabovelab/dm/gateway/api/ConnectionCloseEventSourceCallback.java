
package com.codeabovelab.dm.gateway.api;

import com.codeabovelab.dm.common.security.dto.AuthenticationData;
import com.codeabovelab.dm.common.gateway.ClientConnection;
import com.codeabovelab.dm.common.gateway.ConnectionAttributeKeys;
import com.codeabovelab.dm.common.gateway.events.ClientDisconnectedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;


@Component
public class ConnectionCloseEventSourceCallback implements ConnectionCloseCallback {

    private ConnectionEventHub eventHub;

    @Autowired
    public ConnectionCloseEventSourceCallback(ConnectionEventHub eventHub) {
        this.eventHub = eventHub;
    }

    @Override
    public void connectionClose(ClientConnection connection) {
        AuthenticationData auth = connection.getAttributes().get(ConnectionAttributeKeys.KEY_AUTHENTICATION);
        if(auth == null) {
            return;
        }
        final SecurityContext sc = SecurityContextHolder.getContext();
        sc.setAuthentication(auth);
        try {
            eventHub.listen(ClientDisconnectedEvent.builder()
              .cause(ClientDisconnectedEvent.Cause.SERVER_CLOSE)
              .connectionId(connection.getId())
              .build());
        } finally {
            sc.setAuthentication(null);
        }
    }
}
