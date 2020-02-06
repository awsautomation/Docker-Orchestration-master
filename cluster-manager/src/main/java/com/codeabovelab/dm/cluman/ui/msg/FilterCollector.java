
package com.codeabovelab.dm.cluman.ui.msg;

import com.codeabovelab.dm.cluman.cluster.filter.Filter;
import com.codeabovelab.dm.cluman.cluster.filter.FilterFactory;

/**
 */
class FilterCollector {
    private int counter = 0;
    private final String expr;
    private final Filter filter;

    FilterCollector(FilterFactory ff, String expr) {
        this.expr = expr;
        this.filter = ff.createFilter(expr);
    }

    void collect(Object o) {
        if(filter.test(o)) {
            counter++;
        }
    }

    int getResult() {
        return counter;
    }

    @Override
    public String toString() {
        return "FilterCollector{" +
          "expr='" + expr + '\'' +
          ", counter=" + counter +
          '}';
    }

    UiCountResult.FilteredResult toUi() {
        UiCountResult.FilteredResult ui = new UiCountResult.FilteredResult();
        ui.setCount(counter);
        ui.setFilter(expr);
        return ui;
    }
}
