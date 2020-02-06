

package com.codeabovelab.dm.common.kv;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Options of write operation. <p/>
 * Some engine my not implement all set of options.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class DeleteDirOptions extends WriteOptions {

    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class Builder extends WriteOptions.Builder<DeleteDirOptions, Builder> {
        /**
         * Make operation for all underline items. Usual it allow remove non empty dir.
         */
        private boolean recursive;

        /**
         * Make operation for all underline items. Usual it allow remove non empty dir.
         * @param recursive
         * @return
         */
        public Builder recursive(boolean recursive) {
            setRecursive(recursive);
            return this;
        }

        @Override
        public DeleteDirOptions build() {
            return new DeleteDirOptions(this);
        }
    }

    /**
     * Make operation for all underline items. Usual it allow remove non empty dir.
     */
    private final boolean recursive;

    public static Builder builder() {
        return new Builder();
    }

    public DeleteDirOptions(Builder b) {
        super(b);
        this.recursive = b.recursive;
    }
}
