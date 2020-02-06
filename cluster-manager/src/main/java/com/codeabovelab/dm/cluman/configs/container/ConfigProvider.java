
package com.codeabovelab.dm.cluman.configs.container;

import com.codeabovelab.dm.cluman.model.ImageDescriptor;
import com.codeabovelab.dm.cluman.model.ContainerSource;

public interface ConfigProvider {

    ContainerSource resolveProperties(String cluster, ImageDescriptor image, String imageName,
                                      ContainerSource createContainerArg);

}
