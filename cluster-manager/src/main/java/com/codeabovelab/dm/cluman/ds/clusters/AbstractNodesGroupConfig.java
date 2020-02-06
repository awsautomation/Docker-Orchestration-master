
package com.codeabovelab.dm.cluman.ds.clusters;

import com.codeabovelab.dm.common.kv.mapping.KvMapping;
import com.codeabovelab.dm.common.security.acl.AclSource;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

/**
 */
@JsonTypeInfo(
  use = JsonTypeInfo.Id.NAME,
  include = JsonTypeInfo.As.EXTERNAL_PROPERTY,
  property = "groupType"
)
@JsonSubTypes({
  @JsonSubTypes.Type(value = DefaultNodesGroupConfig.class, name = NodesGroupConfig.TYPE_DEFAULT),
  @JsonSubTypes.Type(value = SwarmNodesGroupConfig.class, name = NodesGroupConfig.TYPE_SWARM),
  @JsonSubTypes.Type(value = DockerClusterConfig.class, name = NodesGroupConfig.TYPE_DOCKER)
})
@Data
public abstract class AbstractNodesGroupConfig<T extends AbstractNodesGroupConfig<T>> implements Cloneable, NodesGroupConfig {

    @KvMapping
    private String name;
    @KvMapping
    private String imageFilter;
    @KvMapping
    private String title;
    @KvMapping
    private String description;
    @KvMapping
    private String defaultNetwork;
    @KvMapping
    private AclSource acl;

    @Override
    @SuppressWarnings("unchecked")
    public T clone() {
        try {
            return (T) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
