

package com.codeabovelab.dm.cluman.ds.clusters;

import com.codeabovelab.dm.common.kv.mapping.KvMapping;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Data
public class DefaultNodesGroupConfig extends AbstractNodesGroupConfig<DefaultNodesGroupConfig> {

    @KvMapping
    private String nodeFilter;

    @JsonCreator
    public DefaultNodesGroupConfig() {

    }

    public DefaultNodesGroupConfig(String name, String nodeFilter) {
        setName(name);
        setNodeFilter(nodeFilter);
    }

}
