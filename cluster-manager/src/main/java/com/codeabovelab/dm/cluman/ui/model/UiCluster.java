
package com.codeabovelab.dm.cluman.ui.model;

import com.codeabovelab.dm.cluman.model.NodeGroupState;
import com.codeabovelab.dm.cluman.model.NodesGroup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

/**
 */
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class UiCluster extends UiClusterEditablePart implements Comparable<UiCluster>, WithUiPermission {

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Entry {
        private int on;
        private int off;

        public void incrementOff() {
            off++;
        }

        public void incrementOn() {
            on++;
        }
    }

    private String name;
    private Set<NodesGroup.Feature> features;
    private Entry nodes;
    private Entry containers;
    private UiPermission permission;
    private NodeGroupState state;
    private Set<String> applications = new HashSet<>();

    @Override
    public int compareTo(UiCluster o) {
        return this.name.compareTo(o.name);
    }
}
