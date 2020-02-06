

package com.codeabovelab.dm.common.kv.mapping;

import com.codeabovelab.dm.common.kv.KvNode;

/**
 * Callback used for handle indexes from kv update requests
 */
interface KvSaveCallback {
    /**
     * Invoked after call set property to server
     * @param name name of property, null for 'this'
     * @param res response from server
     */
    void call(String name, KvNode res);
}
