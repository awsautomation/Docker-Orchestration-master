
package com.codeabovelab.dm.gateway.proxy.common;

import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;

import java.io.IOException;

public class SyncProxyClient implements ProxyClient {

    private final CloseableHttpClient proxyClient;

    public SyncProxyClient(CloseableHttpClient proxyClient) {
        this.proxyClient = proxyClient;
    }

    @Override
    public HttpResponse execute(HttpHost target, HttpRequest request) throws Exception {
        return proxyClient.execute(target, request);
    }

    @Override
    public void start() {
    }

    @Override
    public void close() throws IOException {
        proxyClient.close();
    }
}
