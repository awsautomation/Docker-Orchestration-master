

package com.codeabovelab.dm.common.log;

import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;

@Component
public class RandomUUIDGenerator implements UUIDGenerator {
    private final Random random = new Random();

    @Override
    public String generate() {
        return new UUID(random.nextLong(), random.nextLong()).toString();
    }
}
