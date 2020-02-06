

package com.codeabovelab.dm.common.format;

/**
 * Indicate that format of field is not valid
 *
 * return new ValidableFormatter<>(new PhoneFormatter(), null, new Callback<String>() {
 *   public void call(String arg) {
 *     if (!arg.matches("^[^\\d]*1[^\\d]*[38].*")) {
 *          throw new FormatterException("'" + arg + "' must start with 13 or 18");
 *      }
 *    }
 * });
 */
public class FormatterException extends RuntimeException {
    public FormatterException() {
    }

    public FormatterException(String message) {
        super(message);
    }

    public FormatterException(String message, Throwable cause) {
        super(message, cause);
    }

    public FormatterException(Throwable cause) {
        super(cause);
    }
}
