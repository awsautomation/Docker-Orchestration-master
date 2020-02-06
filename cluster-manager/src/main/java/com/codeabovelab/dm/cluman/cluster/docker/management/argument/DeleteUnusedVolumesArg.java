

package com.codeabovelab.dm.cluman.cluster.docker.management.argument;

import lombok.Data;

import java.util.Map;

/**
 * Planned for 'filters':
 * <pre>
 *     nothing filters are documented
 * </pre>
 */
@Data
public class DeleteUnusedVolumesArg {
    private Map<String, String> filters;
}
