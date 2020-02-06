
package com.codeabovelab.dm.cluman.ui.model;

import com.codeabovelab.dm.cluman.cluster.docker.model.Network;
import com.codeabovelab.dm.cluman.ds.container.ContainerStorage;
import com.codeabovelab.dm.common.utils.StringUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UiNetworkDetails extends UiNetwork {
    private ZonedDateTime created;
    private final List<Peer> peers = new ArrayList<>();


    public UiNetworkDetails from(Network net, ContainerStorage cs) {
        super.from(net, cs);
        this.setCreated(net.getCreated());

        List<Network.PeerInfo> peers = net.getPeers();
        if(peers != null) {
            peers.forEach(peer -> {
                getPeers().add(new Peer().from(peer));
            });
        }
        return this;
    }

    @Data
    public static class Peer {

        private String name;

        private String ip;

        public Peer from(Network.PeerInfo peer) {
            String nameAndId = peer.getName();
            // see https://github.com/docker/docker/issues/28984
            String name = StringUtils.beforeLast(nameAndId, '-');
            setName(name);
            setIp(peer.getIp());
            return this;
        }
    }
}
