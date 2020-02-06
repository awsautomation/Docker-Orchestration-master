
package com.codeabovelab.dm.common.utils;

import com.codeabovelab.dm.common.utils.HttpHeaderSource;
import org.springframework.http.HttpHeaders;
import org.springframework.util.CollectionUtils;

import java.util.Iterator;
import java.util.List;

/**
 * Adapter from {@link org.springframework.http.HttpHeaders } to {@link com.codeabovelab.dm.common.utils.HttpHeaderSource }
 */
public class HttpHeaderSourceAdapter implements HttpHeaderSource {
    private final HttpHeaders headers;

    public HttpHeaderSourceAdapter(HttpHeaders headers) {
        this.headers = headers;
    }

    @Override
    public Iterator<String> iterateNames() {
        return this.headers.keySet().iterator();
    }

    @Override
    public String getValue(String name) {
        List<String> strings = this.headers.get(name);
        if(CollectionUtils.isEmpty(strings)) {
            return null;
        }
        return strings.get(0);
    }
}
