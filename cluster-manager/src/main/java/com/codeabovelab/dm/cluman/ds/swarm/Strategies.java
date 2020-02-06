
package com.codeabovelab.dm.cluman.ds.swarm;

public enum  Strategies {

    DEFAULT,
    SPREAD,
    BINPACK,
    RANDOM;

    public String value() {
        return name().toLowerCase();
    }
}
