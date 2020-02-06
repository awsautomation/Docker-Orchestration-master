

package com.codeabovelab.dm.common.fc;

import java.util.List;

/**
 */
interface IndexFile extends StorageConfig {
    boolean isExists();
    List<String> getList();
    void setList(List<String> list);
    String getId();
    void setId(String id);

    default void init(String id, FbStorage storage) {
        setId(id);
        setMaxFiles(storage.getMaxFiles());
        setMaxFileSize(storage.getMaxFileSize());
    }
}
