
package com.codeabovelab.dm.agent.infocol;

import com.google.common.base.Splitter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

final class InfoUtils {
    static final Splitter SPLITTER_ON_SPACE = Splitter.on(' ').omitEmptyStrings().trimResults();

    static BufferedReader readFile(File file) throws IOException {
        return new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.US_ASCII));
    }

    static long nextLong(Iterator<String> iter) {
        return Long.parseLong(iter.next());
    }
}
