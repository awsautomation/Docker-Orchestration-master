
package com.codeabovelab.dm.cluman.model;

import lombok.Data;

/**
 * Info about storage drive.
 */
@Data
public class DiskInfo {
    /**
     * mount point
     */
    private final String mount;
    private final long used;
    private final long total;
}
