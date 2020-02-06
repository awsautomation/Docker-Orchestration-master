
package com.codeabovelab.dm.cluman.cluster.docker.management.result;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Result of call service
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RemoveImageResult extends ServiceCallResult {

    private String image;

}
