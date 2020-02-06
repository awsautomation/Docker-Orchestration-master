
package com.codeabovelab.dm.cluman.cluster.docker.management.argument;

import lombok.Builder;
import lombok.Data;

// do not remove @Builder from here! (wayerr)
// do not add @AllArgsConstructor
// because we need to add label based filter api for this
@Data
@Builder
public class GetImagesArg {

    /**
     * Instance which only has all=true
     */
    public static final GetImagesArg ALL = GetImagesArg.builder().all(true).build();
    /**
     * Instance which only has all=false
     */
    public static final GetImagesArg NOT_ALL = GetImagesArg.builder().all(false).build();

    private final boolean all;
    private final String name;
}
