

package com.codeabovelab.dm.common.kv.mapping;

/**
 * State of property
 */
class KvPropertyState {
    private final KvProperty property;
    /**
     * Internal storage value, index of last modification.
     */
    private volatile long storageIndex;
    private volatile boolean modified;

    public KvPropertyState(KvProperty property) {
        this.property = property;
    }

    public KvProperty getProperty() {
        return property;
    }

    public long getStorageIndex() {
        return storageIndex;
    }

    public void setStorageIndex(long storageIndex) {
        this.storageIndex = storageIndex;
    }

    public boolean isModified() {
        return modified;
    }

    public void setModified(boolean modified) {
        this.modified = modified;
    }
}
