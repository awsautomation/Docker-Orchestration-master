
package com.codeabovelab.dm.cluman.ds.nodes;

import com.codeabovelab.dm.cluman.model.NodeInfo;
import com.codeabovelab.dm.cluman.model.NodeInfoImpl;
import com.codeabovelab.dm.common.kv.mapping.KvMapAdapter;

class NodesKvMapAdapterImpl implements KvMapAdapter<NodeRegistrationImpl> {
    private NodeStorage nodeStorage;

    public NodesKvMapAdapterImpl(NodeStorage nodeStorage) {
        this.nodeStorage = nodeStorage;
    }

    @Override
    public Object get(String key, NodeRegistrationImpl source) {
        return NodeInfoImpl.builder(source.getNodeInfo());
    }

    @Override
    public NodeRegistrationImpl set(String key, NodeRegistrationImpl source, Object value) {
        NodeInfo ni = (NodeInfo) value;
        if (source == null) {
            NodeInfoImpl.Builder nib = NodeInfoImpl.builder(ni);
            nib.setName(key);
            source = nodeStorage.newRegistration(nib);
        } else {
            source.updateNodeInfo(b -> {
                b.address(ni.getAddress());
                b.setCluster(ni.getCluster());
                b.setIdInCluster(ni.getIdInCluster());
                b.setLabels(ni.getLabels());
            });
        }
        return source;
    }

    @Override
    public Class<?> getType(NodeRegistrationImpl source) {
        return NodeInfoImpl.Builder.class;
    }
}
