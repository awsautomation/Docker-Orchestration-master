
package com.codeabovelab.dm.cluman.model;

/**
 * Some result codes for DockerService
 */
public enum ResultCode {
    OK,
    /**
     * State of system is not modified by call. For example its mean that container is already stopped when we try to stop it.
     */
    NOT_MODIFIED,
    NOT_FOUND,
    ERROR,
    CLIENT_ERROR,
    CONFLICT
}
