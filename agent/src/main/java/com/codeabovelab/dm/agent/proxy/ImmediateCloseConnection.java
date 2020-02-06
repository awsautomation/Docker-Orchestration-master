
package com.codeabovelab.dm.agent.proxy;

import com.codeabovelab.dm.common.utils.Closeables;

import javax.servlet.http.HttpUpgradeHandler;
import javax.servlet.http.WebConnection;

class ImmediateCloseConnection implements HttpUpgradeHandler {
    interface CloseableSupplier {
        AutoCloseable get() throws Exception;
    }

    @Override
    public void init(WebConnection wc) {
        close(wc::getInputStream);
        close(wc::getOutputStream);
    }

    private void close(CloseableSupplier closeable) {
        try {
            AutoCloseable ac = closeable.get();
            Closeables.close(ac);
        } catch (Exception e) {
            // we do not want to known what it happen here
        }
    }

    @Override
    public void destroy() {

    }
}
