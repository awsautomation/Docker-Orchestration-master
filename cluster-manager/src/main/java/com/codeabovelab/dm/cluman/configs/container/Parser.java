
package com.codeabovelab.dm.cluman.configs.container;

import com.codeabovelab.dm.cluman.model.ContainerSource;

import java.io.File;
import java.util.Map;

/**
 * Parses settings and adds result to context
 */
public interface Parser {
    void parse(String fileName, ContainerCreationContext context);
    void parse(File file, ContainerCreationContext context);
    void parse(Map<String, Object> map, ContainerCreationContext context);
    void parse(Map<String, Object> map, ContainerSource arg);
}
