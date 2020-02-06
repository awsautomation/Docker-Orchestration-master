

package com.codeabovelab.dm.common.kv.mapping;

/**
 * iface for modifying value of final fields (it acceptable for collections or maps).
 */
interface FieldSetter<T> {
    void set(T fieldValue, T newValue);
}
