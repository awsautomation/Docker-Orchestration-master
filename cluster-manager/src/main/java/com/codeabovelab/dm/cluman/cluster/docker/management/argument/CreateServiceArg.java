

package com.codeabovelab.dm.cluman.cluster.docker.management.argument;

import com.codeabovelab.dm.cluman.cluster.docker.model.AuthConfig;
import com.codeabovelab.dm.cluman.cluster.docker.model.swarm.Service;
import lombok.Data;

/**
 * 'Create a service. When using this endpoint to create a service using a private repository from the registry,
 * the X-Registry-Auth header must be used to include a base64-encoded AuthConfig object. Refer to the create
 * an image section for more details.'
 */
@Data
public class CreateServiceArg {
    private AuthConfig registryAuth;
    private Service.ServiceSpec spec;
}
