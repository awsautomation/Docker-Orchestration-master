
package com.codeabovelab.dm.common.fc;

/**
 */
public interface StorageConfig {
    long getMaxFileSize();
    void setMaxFileSize(long maxFileSize);
    int getMaxFiles();
    void setMaxFiles(int maxFiles);
}
