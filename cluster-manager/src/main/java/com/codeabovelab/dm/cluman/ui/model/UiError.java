
package com.codeabovelab.dm.cluman.ui.model;

import com.codeabovelab.dm.cluman.ui.HttpException;
import com.codeabovelab.dm.common.utils.Throwables;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * DTO which is used for ui errors
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UiError extends UIResult {
    /**
     * Stack trace of error
     */
    private String stack;

    /**
     * Utility for creating error dto from exception.
     * Also support {@link HttpException }
     * @param ex
     * @return
     */
    public static UiError from(Exception ex) {
        UiError error = new UiError();
        error.setStack(Throwables.printToString(ex));
        if(ex instanceof HttpException) {
            error.setCode(((HttpException)ex).getStatus().value());
        }
        error.setMessage(ex.getMessage());
        return error;
    }

    @Override
    public String toString() {
        return "UiError{" +
                "stack='" + stack + '\'' +
                "} " + super.toString();
    }
}
