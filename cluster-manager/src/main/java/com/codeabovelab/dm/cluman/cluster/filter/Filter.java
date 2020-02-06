
package com.codeabovelab.dm.cluman.cluster.filter;

import java.util.function.Predicate;

/**
 * Function for image filtration.
 */
public interface Filter extends Predicate<Object> {

    static Filter any() {
        return  new Filter() {
            @Override
            public boolean test(Object o) {
                return true;
            }

            @Override
            public String getExpression() {
                return FilterFactory.ANY;
            }
        };
    }

    static Filter noOne() {
        return new Filter() {
            @Override
            public boolean test(Object o) {
                return false;
            }

            @Override
            public String getExpression() {
                return FilterFactory.NO_ONE;
            }
        };
    }

    default String getExpression() {
        return null;
    }
}
