
package com.codeabovelab.dm.cluman.cluster.docker.management.result;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 */
public class ServiceCreateResult extends ServiceCallResult {
    @JsonProperty("ID")
    private String serviceId;
}
