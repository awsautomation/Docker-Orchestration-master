
package com.codeabovelab.dm.gateway.filestorage;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseExtractor;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Extract response to servlet response.
*/
class GetResponseExtractor implements ResponseExtractor<Object> {
    private final HttpServletResponse servletResponse;
    private static final Set<String> FORBIDDEN_HEADERS;
    static {
        Set<String> headers = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        headers.add(HttpHeaders.TRANSFER_ENCODING);
        FORBIDDEN_HEADERS = Collections.unmodifiableSet(headers);
    }

    public GetResponseExtractor(HttpServletResponse servletResponse) {
        this.servletResponse = servletResponse;
    }

    @Override
    public Object extractData(ClientHttpResponse response) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.putAll(response.getHeaders());
        for(Map.Entry<String, List<String>> e: headers.entrySet()) {
            List<String> values = e.getValue();
            for(int i = 0; i < values.size(); i++) {
                final String key = e.getKey();
                if(FORBIDDEN_HEADERS.contains(key)) {
                    continue;
                }
                servletResponse.setHeader(key, values.get(i));
            }
        }
        try(InputStream is = response.getBody();
            ServletOutputStream os = servletResponse.getOutputStream()) {
            IOUtils.copy(is, os);
            servletResponse.flushBuffer();

        }
        return null;
    }
}
