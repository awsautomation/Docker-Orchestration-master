

package com.codeabovelab.dm.common.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class DataSizeTest {

    @Test
    public void test() {
        long srcs[] = new long[]{
          -1, 0, 1,
          -1000, 1000,
          -1024, 1024,
          -999997, 999997,
          -1024 * 1024, 1024 * 1024,
          -1080033, 1080033,
          -1024 * 1024 * 1024, 1024 * 1024 * 1024,
          -1105954078, 1105954078,
        };
        for(long src: srcs) {
            String s = DataSize.toString(src);
            assertNotNull(s);
            long res = DataSize.fromString(s);
            System.out.println("Convert " + src + " to string: " + s + " and parse: " + res);
            assertEquals(src, res);
        }
    }

}