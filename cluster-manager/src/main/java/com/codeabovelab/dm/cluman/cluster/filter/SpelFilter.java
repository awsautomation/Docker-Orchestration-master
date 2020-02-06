
package com.codeabovelab.dm.cluman.cluster.filter;

import com.google.common.base.MoreObjects;
import org.springframework.expression.spel.standard.SpelExpression;
import org.springframework.expression.spel.standard.SpelExpressionParser;


public abstract class SpelFilter<T> extends AbstractFilter<T> {

    private static final SpelExpressionParser parser = new SpelExpressionParser();
    private final SpelExpression expr;

    public SpelFilter(String expr) {
        this.expr = parser.parseRaw(expr);
    }

    public SpelExpression getExpr() {
        return expr;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("expr", expr)
                .toString();
    }
}
