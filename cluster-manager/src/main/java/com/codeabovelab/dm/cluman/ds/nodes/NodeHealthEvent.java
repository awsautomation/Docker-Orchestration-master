
package com.codeabovelab.dm.cluman.ds.nodes;

import com.codeabovelab.dm.cluman.model.EventWithTime;
import com.codeabovelab.dm.cluman.model.NodeMetrics;
import com.codeabovelab.dm.cluman.model.WithCluster;
import lombok.Data;
import org.springframework.util.Assert;

import java.beans.ConstructorProperties;
import java.time.ZonedDateTime;

/**
 */
@Data
public class NodeHealthEvent implements EventWithTime, WithCluster {
    private final String name;
    private final String cluster;
    private final NodeMetrics health;

    @ConstructorProperties({"name", "cluster", "health"})
    public NodeHealthEvent(String name, String cluster, NodeMetrics health) {
        Assert.notNull(name, "name is null");
        this.name = name;
        this.cluster = cluster;//cluster can be null
        Assert.notNull(health, "health is null");
        this.health = health;
    }

    @Override
    public long getTimeInMilliseconds() {
        ZonedDateTime time = health.getTime();
        if(time == null) {
            return Long.MIN_VALUE;
        }
        return time.toEpochSecond();
    }
}
