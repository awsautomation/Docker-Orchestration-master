
package com.codeabovelab.dm.cluman.cluster.docker.management.argument;

import com.codeabovelab.dm.cluman.cluster.docker.model.Statistics;
import com.google.common.util.concurrent.SettableFuture;
import lombok.Builder;
import lombok.Data;

import java.util.function.Consumer;

/**
 */
@Builder(builderClassName = "Builder")
@Data
public class GetStatisticsArg implements WithInterrupter {
    private final String id;
    private final boolean stream;
    private final SettableFuture<Boolean> interrupter = SettableFuture.create();
    private final Consumer<Statistics> watcher;
}
