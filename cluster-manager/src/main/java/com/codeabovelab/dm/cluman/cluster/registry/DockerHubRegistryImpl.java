
package com.codeabovelab.dm.cluman.cluster.registry;

import com.codeabovelab.dm.cluman.cluster.registry.data.ImageCatalog;
import com.codeabovelab.dm.cluman.cluster.registry.data.SearchResult;
import com.codeabovelab.dm.cluman.cluster.registry.model.RegistryAdapter;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;

@Slf4j
public class DockerHubRegistryImpl extends AbstractV2RegistryService implements DockerHubRegistry {

    @Builder
    public DockerHubRegistryImpl(RegistryAdapter adapter) {
        super(adapter);
    }

    @Override
    public SearchResult search(String searchTerm, int page, int count) {
        return new SearchResult();
    }

    @Override
    public ImageCatalog getCatalog() {
        return new ImageCatalog(Collections.emptyList());
    }

    @Override
    public String toRelative(String name) {
        return name;
    }
}
