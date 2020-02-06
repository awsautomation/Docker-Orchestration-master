
package com.codeabovelab.dm.cluman.cluster.filter;

import org.springframework.util.PatternMatchUtils;

/**
 * Uses {@link PatternMatchUtils }
 */
class PatternFilter extends AbstractTextFilter {
    public static final String PROTO = "pattern";
    private final String pattern;

    public PatternFilter(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public String getExpression() {
        return PROTO + ":" + pattern;
    }

    @Override
    protected boolean innerTest(CharSequence text) {
        if(text == null) {
            //obviously that '*' math null strings too
            return "*".equals(pattern);
        }
        return PatternMatchUtils.simpleMatch(pattern, text.toString());
    }
}
