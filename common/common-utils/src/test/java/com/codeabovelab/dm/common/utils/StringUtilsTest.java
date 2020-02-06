
package com.codeabovelab.dm.common.utils;

import com.google.common.base.Splitter;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;

/**
 */
public class StringUtilsTest {

    @Test
    public void testReplace() {
        String src = "$AAA$ some\ns$AAA$b\n$AAA$\n$ SSS$AAA$AAA$\n${B}$";
        String exp = "1 some\ns2b\n3\n$ SSS4AAA$\n${B}$\n";
        AtomicInteger counter = new AtomicInteger();
        StringBuilder sb = new StringBuilder();
        for(String line: Splitter.on("\n").split(src)) {
            sb.append(StringUtils.replace(Pattern.compile("\\$[\\w\\{\\}]+\\$"), line, (s) -> {
                if(!"$AAA$".equals(s)) {
                    return s;
                }
                return Integer.toString(counter.incrementAndGet());
            })).append('\n');
        }
        assertEquals(exp, sb.toString());
    }
}
