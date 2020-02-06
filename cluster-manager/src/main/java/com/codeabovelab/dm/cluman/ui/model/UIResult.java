

package com.codeabovelab.dm.cluman.ui.model;

import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * DTO which is used for result
 */
@Data
public class UIResult {
    /**
     * code like HTTP CODE
     * @return
     */
    private int code;
    /**
     * User friendly error message
     * @return
     */
    private String message;

    /**
     * code like HTTP CODE
     * @param value
     * @return
     */
    public UIResult code(int value) {
        setCode(value);
        return this;
    }

    public UIResult code(HttpStatus value) {
        return code(value.value());
    }

    /**
     * User friendly error message
     */
    public String getMessage() {
        if (message != null) {
            return message;
        } else {
            return "";
        }
    }

}
