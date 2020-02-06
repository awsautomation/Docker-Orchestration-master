
package com.codeabovelab.dm.common.utils;

import java.io.InputStream;
import java.net.URL;

public class Resources {
    public static <T> T load(ClassLoader cl, String name, Loader<InputStream, T> loader) {
        final URL url = cl.getResource(name);
        if(url == null) {
            throw new RuntimeException("Can not find url with name: " + name);
        }
        try(InputStream is = url.openStream()) {
            return loader.apply(is);
        } catch (Exception e) {
            throw new RuntimeException("Can not load: " + name + " from url: " + url, e);
        }
    }

    public interface Loader<A, V> {
        V apply(A arg) throws Exception;
    }
}
