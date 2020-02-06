

package com.codeabovelab.dm.common.mb;

public interface MessageBusInfo<M> {
    /**
     * Id of bus. It unique string which help to identity bust in app environment. <p/>
     * Can be used in error handlers.
     * @return
     */
    String getId();

    /**
     * Type of buss messages.
     * @return
     */
    Class<M> getType();
}
