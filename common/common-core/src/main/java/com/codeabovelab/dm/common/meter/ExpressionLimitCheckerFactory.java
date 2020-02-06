

package com.codeabovelab.dm.common.meter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.util.Assert;

/**
 * Factory for expression limit checker
 */
final class ExpressionLimitCheckerFactory {
    private static final Logger LOG = LoggerFactory.getLogger(ExpressionLimitCheckerFactory.class);
    private final SpelExpressionParser parser = new SpelExpressionParser();
    private final Environment environment;

    public ExpressionLimitCheckerFactory(Environment environment) {
        this.environment = environment;
    }

    /**
     * Create {@link ExpressionLimitChecker } or return null if no limit expression
     * @param checkerSource
     * @return checker or null
     */
    public ExpressionLimitChecker create(ExpressionLimitCheckerSource checkerSource) {
        Assert.notNull(checkerSource, "checkerSource is null");
        checkerSource = configureSource(checkerSource);
        String expressionSource = checkerSource.getExpression();
        if(expressionSource == null) {
            return null;
        }
        Expression expression = parser.parseExpression(expressionSource);
        return new ExpressionLimitChecker(expression, checkerSource.getPeriod(), checkerSource.getTimeUnit());
    }

    private ExpressionLimitCheckerSource configureSource(ExpressionLimitCheckerSource checkerSource) {
        final String checkerSourceString = environment.getProperty("meter[" + checkerSource.getMetricName() + "].watchdogRule");
        if(checkerSourceString == null) {
            return checkerSource;
        }
        // property contains expression, therefore we need to parse it and modify source
        try {
            Expression checkerSourceExpression = parser.parseExpression(checkerSourceString);
            checkerSourceExpression.getValue(checkerSource);
            return checkerSource;
        } catch (Exception e) {
            LOG.error("", e);
        }
        return checkerSource;
    }
}
