
package com.codeabovelab.dm.cluman.reconfig;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * DTO for persist config in JSON, and possible other formats which support direct object  mapping.
 */
@Data
class AppConfigObject {
    private String version;
    private LocalDateTime date;
    private Map<String, Object> data;
}
