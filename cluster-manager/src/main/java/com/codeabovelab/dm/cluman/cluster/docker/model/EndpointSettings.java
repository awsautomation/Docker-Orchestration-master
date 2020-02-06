
package com.codeabovelab.dm.cluman.cluster.docker.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * https://github.com/docker/docker/blob/b2e348f2a6ab2d5396acf4bb56aea7e49c3e2097/api/types/network/network.go#L38
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@lombok.Builder(builderClassName = "Builder")
@AllArgsConstructor
public class EndpointSettings {

    @JsonProperty("IPAMConfig")
    private final EndpointIPAMConfig ipamConfig;

    @JsonProperty("NetworkID")
    private final String networkID;

    @JsonProperty("EndpointID")
    private final String endpointId;

    @JsonProperty("Gateway")
    private final String gateway;

    @JsonProperty("IPAddress")
    private final String ipAddress;

    @JsonProperty("IPPrefixLen")
    private final Integer ipPrefixLen;

    @JsonProperty("IPv6Gateway")
    private final String ipV6Gateway;

    @JsonProperty("GlobalIPv6Address")
    private final String globalIPv6Address;

    @JsonProperty("GlobalIPv6PrefixLen")
    private final Integer globalIPv6PrefixLen;

    @JsonProperty("MacAddress")
    private final String macAddress;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    @lombok.Builder(builderClassName = "Builder")
    @AllArgsConstructor
    public static class EndpointIPAMConfig {
        @JsonProperty("IPv4Address")
        private final String ipv4Address;

        @JsonProperty("IPv6Address")
        private final String ipv6Address;

        @JsonProperty("LinkLocalIPs")
        private final List<String> linkLocalIPs;
    }
}
