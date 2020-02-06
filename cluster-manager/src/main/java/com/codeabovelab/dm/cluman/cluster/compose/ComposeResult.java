

package com.codeabovelab.dm.cluman.cluster.compose;

import com.codeabovelab.dm.cluman.cluster.docker.management.result.ResultCode;
import com.codeabovelab.dm.cluman.cluster.docker.model.ContainerDetails;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ComposeResult {

    private String appName;
    private ResultCode resultCode;
    private List<ContainerDetails> containerDetails;

}
