
package com.codeabovelab.dm.agent.infocol;

import com.codeabovelab.dm.agent.notifier.SysInfo;

public interface Collector {
    void fill(SysInfo info) throws Exception;
}
