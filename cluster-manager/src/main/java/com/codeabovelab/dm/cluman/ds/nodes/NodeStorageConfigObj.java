
package com.codeabovelab.dm.cluman.ds.nodes;

import com.codeabovelab.dm.cluman.model.NodeInfoImpl;
import lombok.Data;

import java.util.List;

/**
 * Object with node storage config, we may using list of node info, but list absent type info, this may
 * cause serialization problem.
 */
@Data
class NodeStorageConfigObj {

    private List<NodeInfoImpl> nodes;
}
