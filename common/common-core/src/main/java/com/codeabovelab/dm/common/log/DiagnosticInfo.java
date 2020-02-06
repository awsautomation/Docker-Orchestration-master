

package com.codeabovelab.dm.common.log;

import lombok.AllArgsConstructor;
import org.slf4j.MDC;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;


/**
 * utility which collect info for {@link org.slf4j.MDC}
 */
@Component
@AllArgsConstructor
public class DiagnosticInfo {

    public static final String KEY_USER = "KEY_USER";
    public static final String REQUEST_UUID = "REQUEST_UUID";

    private final UUIDGenerator uuidGenerator;

    public String getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null) {
            return null;
        }
        return authentication.getName();
    }

    /**
     * do inject diagnostic info to MDC context
     * @return
     * @param requestUid
     */
    public final AutoCloseable injectToContext(String requestUid, String description) {
        if (requestUid == null) {
            requestUid = uuidGenerator.generate();
        }
        MDC.put(KEY_USER, getCurrentUser());
        MDC.put(REQUEST_UUID, requestUid);
        return () -> {
            MDC.remove(KEY_USER);
            MDC.remove(REQUEST_UUID);
        };
    }
}
