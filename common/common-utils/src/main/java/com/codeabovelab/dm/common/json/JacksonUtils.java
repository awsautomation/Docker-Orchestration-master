

package com.codeabovelab.dm.common.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JacksonUtils {

    private JacksonUtils() {}

    public static ObjectMapper objectMapperBuilder() {
        ObjectMapper objectMapper = new ObjectMapper()
          .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
          .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
          .configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false)
          .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        registerModules(objectMapper);
        objectMapper.setSerializationInclusion(JsonInclude.Include.USE_DEFAULTS);
        return objectMapper;
    }

    public static void registerModules(ObjectMapper objectMapper) {
        objectMapper.registerModules(new DmJacksonModule(), new Jdk8Module(), new JavaTimeModule(), new JtModule());
    }

}
