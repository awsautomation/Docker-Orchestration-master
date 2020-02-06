
package com.codeabovelab.dm.cluman.cluster.docker.management;

public interface ResponseStreamProcessor<T> {

    void processResponseStream(StreamContext<T> context);

}
