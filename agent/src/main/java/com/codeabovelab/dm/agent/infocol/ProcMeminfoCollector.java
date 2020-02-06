
package com.codeabovelab.dm.agent.infocol;

import com.codeabovelab.dm.agent.notifier.SysInfo;
import com.codeabovelab.dm.common.utils.DataSize;

import java.io.BufferedReader;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProcMeminfoCollector implements Collector {
    private final Pattern pattern = Pattern.compile("\\w+:\\s+(\\d+)\\s+(\\w+)");
    private final File meminfo;

    public ProcMeminfoCollector(InfoCollector ic) {
        this.meminfo = new File(ic.getRootPath(), "proc/meminfo");
    }

    @Override
    public void fill(SysInfo info) throws Exception {
        try(BufferedReader br = InfoUtils.readFile(meminfo)) {
          
            long total = parse(br.readLine());
            long free = parse(br.readLine());
            // avail - is free + file cache  & etc
            long avail = parse(br.readLine());
            SysInfo.Memory mem = new SysInfo.Memory();
            mem.setTotal(total);
            mem.setAvailable(free);
            // used is total - avail (which include free, unloadable file cache)
            mem.setUsed(total - avail);
            info.setMemory(mem);
        }
    }

    private long parse(String line) {
        Matcher matcher = pattern.matcher(line);
        if(!matcher.matches()) {
            throw new IllegalArgumentException("Can not match: '" + line + "' with " + pattern);
        }
        long val = Long.parseLong(matcher.group(1));
        String multStr = matcher.group(2);
        long mult = DataSize.parseMultiplier(multStr);
        return val + mult;
    }
}
