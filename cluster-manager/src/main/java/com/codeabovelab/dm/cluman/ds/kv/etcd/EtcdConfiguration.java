
package com.codeabovelab.dm.cluman.ds.kv.etcd;

import com.codeabovelab.dm.cluman.ds.swarm.SwarmDiscoveryUrlFunction;
import lombok.extern.slf4j.Slf4j;
import mousio.etcd4j.EtcdClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
@Slf4j
public class EtcdConfiguration {


    //TODO: add auth
    @Value("${dm.kv.etcd.urls}")
    private String[] etcdUrls;

    @Value("${dm.kv.prefix:/cluman}")
    private String prefix;

    @Bean
    public EtcdClientWrapper client() {
        List<URI> uris = new ArrayList<>();
        for (String etcdUrl : etcdUrls) {
            uris.add(URI.create(etcdUrl));
        }
        log.info("About to connect to etcd: {}", (Object)etcdUrls);
        EtcdClient etcd = new EtcdClient(uris.toArray(new URI[uris.size()]));
        return new EtcdClientWrapper(etcd, prefix.trim());
    }

    @Bean
    SwarmDiscoveryUrlFunction swarmDiscoveryUrlFunction(EtcdConfiguration etcdConfiguration) {
        return new SwarmDiscoveryUrlFunction.Etcd(Arrays.stream(etcdUrls)
          .map((s) -> s.substring(s.lastIndexOf('/') + 1))
          .collect(Collectors.toList()));
    }
}
