
package com.codeabovelab.dm.cluman.cluster.docker.management.argument;

public enum Reschedule {

    ON_NODE_FAILURE("on-node-failure");

    private final String value;

    Reschedule(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
