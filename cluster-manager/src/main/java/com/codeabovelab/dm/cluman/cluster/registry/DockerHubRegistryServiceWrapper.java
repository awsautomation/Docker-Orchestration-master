
package com.codeabovelab.dm.cluman.cluster.registry;


import com.codeabovelab.dm.cluman.cluster.registry.data.ImageCatalog;
import com.codeabovelab.dm.cluman.cluster.registry.data.SearchResult;
import com.codeabovelab.dm.cluman.cluster.registry.data.Tags;
import com.codeabovelab.dm.cluman.cluster.registry.model.RegistryCredentials;
import com.codeabovelab.dm.cluman.cluster.registry.model.RegistryConfig;
import com.codeabovelab.dm.cluman.model.ImageDescriptor;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

import static org.springframework.util.StringUtils.hasText;

/**
 * Docker registry read-only API
 */
@Slf4j
@Builder
class DockerHubRegistryServiceWrapper implements RegistryService, DockerHubRegistry {

    private final DockerHubRegistry dockerHubRegistry;
    private final String registryName;

    public ImageCatalog getCatalog() {
        return dockerHubRegistry.getCatalog();
    }

    public Tags getTags(String imageName) {
        return dockerHubRegistry.getTags(merge(registryName, imageName));
    }

    public ImageDescriptor getImage(String name, String reference) {
        return dockerHubRegistry.getImage(merge(registryName, name), reference);
    }

    @Override
    public ImageDescriptor getImage(String fullImageName) {
        return dockerHubRegistry.getImage(fullImageName);
    }

    @Override
    public void deleteTag(String name, String reference) {
        dockerHubRegistry.deleteTag(merge(registryName, name), reference);
    }

    @Override
    public RegistryConfig getConfig() {
        return dockerHubRegistry.getConfig();
    }

    @Override
    public RegistryCredentials getCredentials() {
        return dockerHubRegistry.getCredentials();
    }

    @Override
    public boolean checkHealth() {
        return dockerHubRegistry.checkHealth();
    }

    @Override
    public SearchResult search(String searchTerm, int page, int count) {
        return dockerHubRegistry.search(searchTerm, page, count);
    }

    private static String merge(String registryName, String name) {
        if (name.contains("/")) {
            return name;
        }
        return (hasText(registryName) ? registryName : "library") + "/" + name;
    }

    @Override
    public String toRelative(String name) {
        return name;
    }
}
