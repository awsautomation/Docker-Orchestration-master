

package com.codeabovelab.dm.common.kv.mapping;

import com.fasterxml.jackson.databind.JavaType;

/**
 */
public interface KvPropertyContext {
    String getKey();

    JavaType getType();
}
