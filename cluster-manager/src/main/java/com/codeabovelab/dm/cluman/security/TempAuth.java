
package com.codeabovelab.dm.cluman.security;

import com.codeabovelab.dm.common.security.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.Assert;

/**
 * Utility for temporary credentials. Used in cases when non privileged code must run parts with high privileges.
 */
@Slf4j
public final class TempAuth implements AutoCloseable {

    private final Authentication newAuth;
    private final SecurityContext context;
    private final SecurityContext oldContext;
    private AccessContextHolder aclHolder;

    TempAuth(Authentication newAuth) {
        Assert.notNull(newAuth, "Authentication is null");
        this.newAuth = newAuth;
        this.oldContext = SecurityContextHolder.getContext();
        this.context = SecurityContextHolder.createEmptyContext();
    }

    /**
     * Do <code>open(SecurityUtils.AUTH_SYSTEM)</code>
     * @return
     */
    public static TempAuth asSystem() {
        return open(SecurityUtils.AUTH_SYSTEM);
    }

    public static TempAuth open(Authentication authentication) {
        TempAuth tempAuth = new TempAuth(authentication);
        tempAuth.init();
        return tempAuth;
    }

    private void init() {
        context.setAuthentication(newAuth);
        SecurityContextHolder.setContext(context);
        AccessContextFactory acf = AccessContextFactory.getInstanceOrNull();
        if(acf != null) {
            // we must open new context only when has factory
            this.aclHolder = acf.open();
        }
    }

    @Override
    public void close() {
        SecurityContext currContext = SecurityContextHolder.getContext();
        if(currContext != context) {
            log.warn("Current context \"{}\" not equal with expected: \"{}\"", currContext, context);
        }
        SecurityContextHolder.setContext(oldContext);
        if(aclHolder != null) {
            aclHolder.close();
        }
    }
}
