
package com.codeabovelab.dm.cluman.job;

import lombok.Data;

import java.lang.reflect.Type;

/**
 * Info about job parameter
 */
@Data
public final class JobParameterDescription {

    private final String name;
    private final Type type;
    private final boolean required;
    private final boolean in;
    private final boolean out;
}
