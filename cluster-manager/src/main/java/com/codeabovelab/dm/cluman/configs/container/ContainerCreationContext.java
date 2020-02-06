
package com.codeabovelab.dm.cluman.configs.container;

import com.codeabovelab.dm.cluman.model.ContainerSource;
import com.codeabovelab.dm.cluman.model.ImageDescriptor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Context of config parser
 */
@Data
@Builder
public class ContainerCreationContext {
    @NotNull
    private ImageDescriptor image;
    @NotNull
    private String imageName;
    private String cluster;
    private Optional<String> containerName;

    private final List<ContainerSource> argList = new ArrayList<>();

    public void addCreateContainerArg(ContainerSource createContainerArg) {
        argList.add(createContainerArg);
    }

}
