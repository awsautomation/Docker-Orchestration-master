
package com.codeabovelab.dm.cluman.pipeline.schema;

import lombok.Data;

import java.util.Map;

/**
 */
@Data
public class Action {

    private String name;
    private Map<String, String> arguments;
    private Order order;

    public enum Order {
        BEFORE, AFTER
    }
}
