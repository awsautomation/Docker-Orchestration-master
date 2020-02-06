

package com.codeabovelab.dm.cluman.cluster.application;

import com.codeabovelab.dm.cluman.cluster.docker.management.result.ServiceCallResult;
import com.codeabovelab.dm.cluman.model.Application;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreateApplicationResult extends ServiceCallResult {

    Application application;
}
