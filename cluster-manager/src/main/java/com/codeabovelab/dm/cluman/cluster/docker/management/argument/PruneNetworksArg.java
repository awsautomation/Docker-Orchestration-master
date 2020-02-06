

package com.codeabovelab.dm.cluman.cluster.docker.management.argument;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * Here must be network filters, but it not documented in docker API.
 */
@Data
public class PruneNetworksArg {
    /**
     * mutable map of filters.
     */
    private final Map<String, String> filters = new HashMap<>();
}
