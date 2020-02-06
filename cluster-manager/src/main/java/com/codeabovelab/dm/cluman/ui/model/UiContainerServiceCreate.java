

package com.codeabovelab.dm.cluman.ui.model;
import com.codeabovelab.dm.cluman.cluster.docker.model.swarm.Service;
import com.codeabovelab.dm.cluman.model.ContainerService;
import com.codeabovelab.dm.cluman.model.Port;
import com.codeabovelab.dm.cluman.model.ServiceSource;
import com.codeabovelab.dm.cluman.source.SourceUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

/**
 * UI representation for Container service create.
 *
 * @see ContainerService
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UiContainerServiceCreate extends ServiceSource {

    @ApiModelProperty("service.version, need for update")
    protected long version;
    protected final List<Port> ports = new ArrayList<>();

    public Service.ServiceSpec.Builder toServiceSpec() {
        Service.ServiceSpec.Builder ssb = Service.ServiceSpec.builder();
        SourceUtil.fromSource(this, ssb);
        return ssb;
    }
}
