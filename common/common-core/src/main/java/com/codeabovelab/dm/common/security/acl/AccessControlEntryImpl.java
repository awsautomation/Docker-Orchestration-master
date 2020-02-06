

package com.codeabovelab.dm.common.security.acl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.acls.model.*;
import org.springframework.util.Assert;


/**
 * AccessControlEntry implementation. <p/> 
 * it created because original implementation design does not allow modification from custom Acl implementations
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AccessControlEntryImpl extends AceSource implements AccessControlEntry, AuditableAccessControlEntry {

    public static class Builder extends AceSource.AbstractBuilder<Builder> {
        private Acl acl;

        @Override
        public Acl getAcl() {
            return acl;
        }

        public Builder acl(Acl acl) {
            setAcl(acl);
            return this;
        }
        
        public void setAcl(Acl acl) {
            this.acl = acl;
        }

        /**
         * copy field values from specified entity
         * @param entry
         * @return
         */
        public Builder from(AccessControlEntry entry) {
            super.from(entry);
            this.acl = entry.getAcl();
            return this;
        }
        
        public AccessControlEntryImpl build() {
            return new AccessControlEntryImpl(this);
        }
    }
    
    private final Acl acl;

    private AccessControlEntryImpl(Builder b) {
        super(b);
        Assert.notNull(b.acl, "Acl required");
        this.acl = b.acl;
    }

    @Override
    public Acl getAcl() {
        return acl;
    }
}
