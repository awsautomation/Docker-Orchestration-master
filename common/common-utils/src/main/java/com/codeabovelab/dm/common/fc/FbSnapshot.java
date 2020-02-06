

package com.codeabovelab.dm.common.fc;

import java.util.function.Consumer;

/**
 * Snapshot whic allo readonly operation over structure. Usual it iteration (throught visitor concept).
 */
public interface FbSnapshot<E> extends AutoCloseable {
    void visit(int offset, Consumer<E> consumer);
}
