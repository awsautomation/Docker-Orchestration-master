
package com.codeabovelab.dm.agent.infocol;

import com.codeabovelab.dm.agent.notifier.SysInfo;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class InfoCollector {
    private final String rootPath;
    private final List<Collector> collectors;
    /**
     * Create new instance of info collector.
     * @param rootPath path to mounter root, if not specified use '/'
     */
    public InfoCollector(String rootPath) {
        this.rootPath = MoreObjects.firstNonNull(rootPath, "/");
        this.collectors = ImmutableList.of(new ProcStatCollector(this), new ProcMeminfoCollector(this), new NetCollector(this));
    }

    public String getRootPath() {
        return rootPath;
    }

    /**
     * Get current info. Some Collectors may periodically gather info, therefore you must manually cal {@link #refresh()}
     * @see #refresh()
     * @return info
     */
    public SysInfo getInfo() {
        SysInfo info = new SysInfo();
        collectors.forEach(c -> safe(() -> c.fill(info)));
        return info;
    }

    /**
     * For proper work you need at least two invocation of this method, between {@link #getInfo()}.
     * Not that small (less than one second) timeout between invocation may cause incorrect results.
     */
    public void refresh() {
        collectors.forEach(c -> {
            if(!(c instanceof Refreshable)) {
                return;
            }
            safe(((Refreshable) c)::refresh);
        });
    }

    private void safe(UnsafeRunnable runnable) {
        try {
            runnable.run();
        } catch (Exception e) {
            log.error("Can not execute {}", runnable, e);
        }
    }
}
