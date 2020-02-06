

package com.codeabovelab.dm.cluman.batch;

import com.codeabovelab.dm.cluman.cluster.docker.management.result.ResultCode;
import com.codeabovelab.dm.cluman.cluster.docker.management.result.ServiceCallResult;

/**
 * Some utilities
 */
public class BatchUtils {

    /**
     * Target version of image after operation
     */
    public static final String JP_IMAGE_TARGET_VERSION = "createContainer.image.version";
    // common job parameters
    public static final String JP_CLUSTER = "cluster";
    public static final String JP_ROLLBACK_ENABLE = "rollbackEnable";
    public static final String FILTER = "Filter";

    /**
     * If result is not an OK then construct and throw exception.
     * @param res
     */
    public static void checkThatIsOk(ServiceCallResult res) {
        ResultCode code = res.getCode();
        if(code != ResultCode.OK) {
            throw new RuntimeException(code + " " + res.getMessage());
        }
    }

    /**
     * If result is not an OK and not an NOT_MODIFIED then construct and throw exception.
     * @param res
     */
    public static void checkThatIsOkOrNotModified(ServiceCallResult res) {
        ResultCode code = res.getCode();
        if(code != ResultCode.OK && code != ResultCode.NOT_MODIFIED) {
            throw new RuntimeException(code + " " + res.getMessage());
        }
    }

}
