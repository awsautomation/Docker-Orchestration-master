
package com.codeabovelab.dm.cluman.objprinter;

import lombok.AllArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

/**
 */
@Component
@AllArgsConstructor
public class ObjectPrinterFactory {
    private final ConversionService conversionService;

    /**
     * Create object which print argument in human readable format in {@link Object#toString()}
     */
    public Object printer(Object src) {
        return new LazyObjectPrinter(this, src);
    }

    void print(Object val, StringBuilder to) {
        String res;
        try {
            res = conversionService.convert(val, String.class);
        } catch (Exception e) {
            res = val.toString();
        }
        to.append(res);
    }
}
