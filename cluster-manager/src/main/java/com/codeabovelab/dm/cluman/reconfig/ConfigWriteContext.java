
package com.codeabovelab.dm.cluman.reconfig;

import lombok.Builder;
import org.springframework.util.MimeType;

/**
 */
@Builder(builderClassName = "Builder")
public class ConfigWriteContext {
    private final MimeType mimeType;
}
