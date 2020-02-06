
package com.codeabovelab.dm.cluman.model;

import com.codeabovelab.dm.cluman.objprinter.ObjPrint;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Any event with time in ms (it used for sorting  and filtering in history).
 */
public interface EventWithTime {

    @ObjPrint(ignore = true)
    @JsonIgnore
    long getTimeInMilliseconds();
}
