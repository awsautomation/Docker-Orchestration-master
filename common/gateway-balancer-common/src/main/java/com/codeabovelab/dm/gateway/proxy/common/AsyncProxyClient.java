
package com.codeabovelab.dm.gateway.proxy.common;

import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;

import java.io.IOException;

public class AsyncProxyClient implements ProxyClient {

    private final CloseableHttpAsyncClient proxyClient;

    public AsyncProxyClient(CloseableHttpAsyncClient proxyClient) {
        this.proxyClient = proxyClient;
    }

    @Override
    public HttpResponse execute(HttpHost target, HttpRequest request) throws Exception {
        return proxyClient.execute(target, request, null).get();
    }

    @Override
    public void start() {
        proxyClient.start();
    }

    @Override
    public void close() throws IOException {
        proxyClient.close();
    }
}
