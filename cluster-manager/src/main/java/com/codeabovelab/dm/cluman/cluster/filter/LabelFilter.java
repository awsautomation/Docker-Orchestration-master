
package com.codeabovelab.dm.cluman.cluster.filter;

import com.codeabovelab.dm.cluman.model.Labels;
import com.codeabovelab.dm.common.utils.StringUtils;
import com.google.common.base.MoreObjects;
import com.google.common.base.Splitter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class LabelFilter extends AbstractFilter<Labels> {

    public static final String PROTO = "labels";
    private static final Splitter SPLITTER = Splitter.on(',').trimResults();
    private final Map<String, String> criteriaLabels;
    private final String expr;

    public LabelFilter(String expr) {
        this.expr = PROTO + ":" + expr;
        Assert.notNull(expr, "criteriaLabelsMap must not be null");
        this.criteriaLabels = SPLITTER.splitToList(expr).stream().collect(Collectors.toMap(
                s -> StringUtils.before(s, '='),
                s -> StringUtils.after(s, '=')));
    }

    public LabelFilter(Map<String, String> criteriaLabels) {
        Assert.notNull(criteriaLabels, "criteriaLabelsMap must not be null");
        this.criteriaLabels = criteriaLabels;
        this.expr = criteriaLabels.entrySet().stream().map((e) -> e.getKey() + "=" + e.getValue()).collect(Collectors.joining(","));
    }

    @Override
    public String getExpression() {
        return expr;
    }

    private boolean required(String value) {
        return value.charAt(0) != '!';
    }

    @Override
    protected boolean innerTest(Labels ifc) {
        for (Map.Entry<String, String> entry : criteriaLabels.entrySet()) {
            String val = entry.getValue();
            Map<String, String> labels = ifc.getLabels();
            String labelVal = labels.get(entry.getKey());
            boolean res = required(val) ? val.equals(labelVal) : !val.substring(1).equals(labelVal);
            if (!res) {
                log.info("not equals {} : {}", val, labelVal);
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("criteriaLabels", criteriaLabels)
                .add("expr", expr)
                .omitNullValues()
                .toString();
    }
}
