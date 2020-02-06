
package com.codeabovelab.dm.cluman.cluster.registry.model;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RegistriesConfig {

    List<RegistryConfig> registries = new ArrayList<>();
}
