
package com.codeabovelab.dm.cluman.reconfig;

/**
 * Object which support export/import of configuration.
 */
public interface ReConfigurableAdapter {

    /**
     * Produce object which can be serialized into config. Context provide some information about
     * current config format and etc.
     * @param ctx
     * @return
     */
    Object getConfig(ConfigWriteContext ctx);

    /**
     * Set readed config into object.
     * @param ctx
     * @param o object which retrieved from {@link #getConfig(ConfigWriteContext)}, serialized into config,
     *          then deserialized
     */
    void setConfig(ConfigReadContext ctx, Object o);
}
