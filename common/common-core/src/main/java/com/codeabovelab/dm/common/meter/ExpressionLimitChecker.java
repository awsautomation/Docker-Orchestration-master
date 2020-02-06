

package com.codeabovelab.dm.common.meter;

import org.springframework.expression.Expression;
import org.springframework.util.Assert;

import java.util.concurrent.TimeUnit;

/**
 * limit checked which limits defined by expression
 */
public class ExpressionLimitChecker implements LimitChecker {

    private final long period;
    private final TimeUnit timeUnit;
    private final Expression expression;

    public ExpressionLimitChecker(Expression expression, long period, TimeUnit timeUnit) {
        Assert.notNull(expression, "expression can't be null");
        Assert.notNull(timeUnit, "timeUnit can't be null");
        this.period = period;
        this.timeUnit = timeUnit;
        this.expression = expression;
    }

    @Override
    public LimitExcess check(LimitCheckContext context) {
        Object value = expression.getValue(new MetricExpressionRoot(context.getMetric()));
        if(value == null || value instanceof Boolean && !((Boolean) value)) {
            return null;
        }
        // TODO add diagnostic info
        return LimitExcess.builder()
          .message("'" + expression.getExpressionString() + "' is exceeded")
          .metric(context.getMetricId())
          .build();
    }

    @Override
    public long getPeriod() {
        return timeUnit.toMillis(this.period);
    }
}
