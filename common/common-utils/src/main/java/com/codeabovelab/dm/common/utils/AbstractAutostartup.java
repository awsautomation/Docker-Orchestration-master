

package com.codeabovelab.dm.common.utils;

import org.springframework.context.SmartLifecycle;

import java.util.ArrayList;
import java.util.List;

public class AbstractAutostartup implements SmartLifecycle {

    private boolean running;
    private final List<AutoCloseable> closeables = new ArrayList<>();

    @Override
    public boolean isAutoStartup() {
        return true;
    }

    @Override
    public final void stop(Runnable callback) {
        if(!this.running) {
            return;
        }
        this.running = false;
        Closeables.closeAll(closeables);
        closeables.clear();
        stopInner(callback);
    }

    @Override
    public final void start() {
        this.running = true;
        startInner();
    }

    /**
     * Here you may place own shutdown logic. Do not forget call <code>callback.run()</code>
     */
    protected void stopInner(Runnable callback) {
        callback.run();
    }

    /**
     * Here you may place own startup logic.
     */
    protected void startInner() {

    }


    @Override
    public void stop() {
    }

    @Override
    public boolean isRunning() {
        return running;
    }

    @Override
    public int getPhase() {
        return 0;
    }

    protected void addToClose(AutoCloseable closeable) {
        this.closeables.add(closeable);
    }
}
