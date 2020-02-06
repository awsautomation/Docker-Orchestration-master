
package com.codeabovelab.dm.cluman.ds.nodes;

import com.codeabovelab.dm.cluman.model.NodeInfoImpl;

interface NodeUpdateHandler {
    void fireNodeModification(NodeRegistration nr, String action, NodeInfoImpl old, NodeInfoImpl curr);
}
