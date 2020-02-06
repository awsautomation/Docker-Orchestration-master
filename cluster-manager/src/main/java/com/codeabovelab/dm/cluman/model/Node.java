
package com.codeabovelab.dm.cluman.model;

/**
 * Swarm cluster node. Represent docker node.
 */
public interface Node extends DockerServiceAddress, Named {

    /**
     * Name of node (used as prefix of container name in swarm). It can be host name, but do not required to be resolvable out of node.
     * @return name of node
     */
    String getName();

}
