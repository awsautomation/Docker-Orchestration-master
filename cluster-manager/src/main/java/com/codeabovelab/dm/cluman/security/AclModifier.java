
package com.codeabovelab.dm.cluman.security;

import com.codeabovelab.dm.common.security.acl.AclSource;

/**
 */
public interface AclModifier {
    /**
     * Modify builder.
     * @param builder
     * @return true if builder is modified
     */
    boolean modify(AclSource.Builder builder);
}
