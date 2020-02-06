
package com.codeabovelab.dm.gateway.proxy.common;

import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;

import java.io.Closeable;


public interface ProxyClient extends Closeable {

    HttpResponse execute(final HttpHost target, final HttpRequest request) throws Exception;

    void start();
}
