
package com.codeabovelab.dm.cluman.security;

import com.codeabovelab.dm.common.security.acl.ExtPermissionGrantingStrategy;
import org.springframework.security.acls.model.AclService;
import org.springframework.security.acls.model.SidRetrievalStrategy;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 */
public class AccessContextFactory {
    private static final ThreadLocal<AccessContext> TL = new ThreadLocal<>();
    private static final Object lock = new Object();
    private static volatile AccessContextFactory instance;

    final AclService aclService;
    final ExtPermissionGrantingStrategy pgs;
    final SidRetrievalStrategy sidStrategy;

    public AccessContextFactory(AclService aclService, ExtPermissionGrantingStrategy pgs, SidRetrievalStrategy sidStrategy) {
        this.aclService = aclService;
        this.pgs = pgs;
        this.sidStrategy = sidStrategy;
    }

    /**
     * * Obtain context from thread local, if it actual and not null, otherwise create new context (but not place it to thread local).
     * @see #open()
     * @return not null context
     */
    public AccessContext getContext() {
        AccessContext ac = TL.get();
        if(ac == null || !ac.isActual()) {
            ac = new AccessContext(this);
        }
        return ac;
    }

    /**
     * Obtain context from thread local. <p/>
     * Throw exception when existed local context not complies with current authentication.
     * @return context
     */
    public static AccessContext getLocalContext() {
        AccessContext ac = TL.get();
        if(ac != null) {
            ac.assertActual();
        } else {
            throw new IllegalStateException("No local context");
        }
        return ac;
    }

    /**
     * Open context and place it to thread local.
     * @see #getContext()
     * @return
     */
    public AccessContextHolder open() {
        AccessContext old = TL.get();
        if(old != null && old.isActual()) {
            // context is not our, and is actual
            return new AccessContextHolder(old, () -> {});
        }
        AccessContext ac = new AccessContext(this);
        TL.set(ac);
        return new AccessContextHolder(ac, () -> {
            AccessContext curr = TL.get();
            Assert.isTrue(ac == curr, "Invalid current context: " + curr + " expect: " + ac);
            TL.set(old);
        });
    }

    /**
     * It must not be public
     * @return current factory
     */
    static AccessContextFactory getInstance() {
        AccessContextFactory acf = getInstanceOrNull();
        if(acf == null) {
            throw new IllegalStateException("No instance.");
        }
        return acf;
    }

    static AccessContextFactory getInstanceOrNull() {
        synchronized (lock) {
            return instance;
        }
    }

    @PostConstruct
    public void postConstruct() {
        synchronized (lock) {
            if(instance != null) {
                throw new IllegalStateException("Factory already has instance.");
            }
            instance = this;
        }
    }

    @PreDestroy
    public void preDestroy() {
        synchronized (lock) {
            if(instance != this) {
                throw new IllegalStateException("Factory has different instance.");
            }
            instance = null;
        }
    }
}
