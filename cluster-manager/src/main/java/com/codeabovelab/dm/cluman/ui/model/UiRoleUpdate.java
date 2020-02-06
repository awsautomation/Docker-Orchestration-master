

package com.codeabovelab.dm.cluman.ui.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UiRoleUpdate extends UiRole {
    private boolean delete;
}
