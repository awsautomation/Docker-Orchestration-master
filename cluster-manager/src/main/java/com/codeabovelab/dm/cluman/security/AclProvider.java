
package com.codeabovelab.dm.cluman.security;

import com.codeabovelab.dm.common.security.acl.AclSource;

import java.io.Serializable;
import java.util.function.Consumer;

/**
 * Provide acl source for specified object id.
 */
public interface AclProvider {
    AclSource provide(Serializable id);

    void update(Serializable id, AclModifier operator);

    void list(Consumer<AclSource> consumer);
}
