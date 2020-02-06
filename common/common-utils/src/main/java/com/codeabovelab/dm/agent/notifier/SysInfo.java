

package com.codeabovelab.dm.agent.notifier;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;


@Data
public class SysInfo {

    @Data
    public static class Disk {
        private long total;
        private long used;
    }

    @Data
    public static class Memory {
        private long total;
        private long used;
        private long available;
    }

    @Data
    public static class Net {
        private long bytesIn;
        private long bytesOut;
    }

    private float cpuLoad;
    private Memory memory;
    private final Map<String, Disk> disks = new HashMap<>();
    private final Map<String, Net> net = new HashMap<>();
}
