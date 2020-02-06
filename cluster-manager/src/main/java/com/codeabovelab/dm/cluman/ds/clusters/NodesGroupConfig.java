
package com.codeabovelab.dm.cluman.ds.clusters;

/**
 */
public interface NodesGroupConfig {
    /**
     * Cluster is present simple group of nodes.
     */
    String TYPE_DEFAULT = "DEFAULT";
    /**
     * Cluster contains nodes united by standalone swarm.
     */
    String TYPE_SWARM = "SWARM";
    /**
     * Cluster contains nodes united by docker in swarm-mode.
     */
    String TYPE_DOCKER = "DOCKER";

    String getName();
    void setName(String name);
    String getImageFilter();
    void setImageFilter(String imageFilter);
    String getTitle();
    void setTitle(String title);
    String getDescription();
    void setDescription(String description);

    static <T extends NodesGroupConfig> T copy(NodesGroupConfig src, T dst) {
        dst.setName(src.getName());
        dst.setImageFilter(src.getImageFilter());
        dst.setTitle(src.getTitle());
        dst.setDescription(src.getDescription());
        return dst;
    }
}
