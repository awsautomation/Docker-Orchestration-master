

package com.codeabovelab.dm.common.gateway;

import java.util.Collection;
/**
 * This interface is used by connection management command handlers. <p/>
 * Note that this interface implementation must be threadsafe.
 */
public interface ClientsConnections {

    /**
     * Return collection of all current clients connections.
     * @return
     */
    void getConnections(Collection<ClientConnection> connections);

    /**
     * Return collection of ids all current clients connections. Usual this method must faster than {@link #getConnections(java.util.Collection)} ,
     * or in worst case not slower.
     * @see ClientConnection#getId()
     * @return
     */
    void getConnectionsIds(Collection<String> ids);

    /**
     * Return connection by its id.
     * @param id
     * @return
     */
    ClientConnection getConnection(String id);
    ClientConnection getConnectionByDevice(String device);
}
