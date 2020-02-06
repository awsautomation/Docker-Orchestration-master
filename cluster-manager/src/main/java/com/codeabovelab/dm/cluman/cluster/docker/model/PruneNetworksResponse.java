
package com.codeabovelab.dm.cluman.cluster.docker.model;

import com.codeabovelab.dm.cluman.cluster.docker.management.result.ServiceCallResult;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PruneNetworksResponse extends ServiceCallResult {
    @JsonProperty("NetworksDeleted")
    private List<String> networks;
}
