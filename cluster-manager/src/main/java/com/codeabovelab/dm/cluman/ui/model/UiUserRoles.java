

package com.codeabovelab.dm.cluman.ui.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 */
@Data
public class UiUserRoles {

    private final List<UiRoleUpdate> roles = new ArrayList<>();
}
