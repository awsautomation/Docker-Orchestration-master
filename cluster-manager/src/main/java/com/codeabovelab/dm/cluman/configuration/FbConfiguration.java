
package com.codeabovelab.dm.cluman.configuration;

import com.codeabovelab.dm.cluman.persistent.PersistentBusFactory;
import com.codeabovelab.dm.common.fc.FbStorage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = PersistentBusFactory.class)
public class FbConfiguration {
    @Bean
    FbStorage fileBackedStorage(@Value("${dm.fbstorage.location}") String storagePath) {
        return FbStorage.builder()
          .maxFileSize(1024 * 1024 * 512)
          .path(storagePath)
          .build();
    }
}
