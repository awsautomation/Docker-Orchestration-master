
package com.codeabovelab.dm.cluman.model;

/**
 * Usually event with action.
 */
public interface WithAction {
    /**
     * Action name
     * @see StandardActions
     * @return
     */
    Object getAction();
}
