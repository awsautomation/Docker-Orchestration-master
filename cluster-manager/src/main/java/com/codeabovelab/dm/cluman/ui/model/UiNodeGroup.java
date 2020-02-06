
package com.codeabovelab.dm.cluman.ui.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 */
@Data
public class UiNodeGroup implements WithUiPermission {
    private String name;
    /**
     * SpEL string which applied to images. It evaluated over object with 'tag(name)' and 'label(key, val)' functions,
     * also it has 'r(regexp)' function which can combined with other, like: <code>'spel:tag(r(".*_dev")) or label("dev", "true")'</code>.
     */
    @ApiModelProperty("SpEL string which applied to images. It evaluated over object with 'tag(name)' and 'label(key, val)' functions,\n" +
      "also it has 'r(regexp)' function which can combined with other, like: <code>'spel:tag(r(\".*_dev\")) or label(\"dev\", \"true\")'</code>.")
    private String filter;
    private UiPermission permission;
}
