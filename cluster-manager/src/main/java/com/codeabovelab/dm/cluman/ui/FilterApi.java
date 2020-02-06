

package com.codeabovelab.dm.cluman.ui;

import com.codeabovelab.dm.cluman.ui.model.UISearchQuery;
import com.codeabovelab.dm.common.utils.Comparables;
import lombok.extern.slf4j.Slf4j;
import org.springframework.expression.spel.standard.SpelExpression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.codeabovelab.dm.cluman.ui.model.UISearchQuery.SortOrder.ASC;
import static com.codeabovelab.dm.common.utils.PojoBeanUtils.getValue;
import static com.google.common.base.MoreObjects.firstNonNull;

@Slf4j
@Component
public class FilterApi {

    private static final SpelExpressionParser parser = new SpelExpressionParser();

    public <T> Collection<T> listNodes(Collection<T> collection, UISearchQuery searchQuery) {
        final String criteria = searchQuery.getCriterias();
        final List<UISearchQuery.SearchOrder> orders = firstNonNull(searchQuery.getOrders(), Collections.emptyList());
        //init sorting
        Comparator<T> comparing = (t1, t2) -> 0;
        for (UISearchQuery.SearchOrder order : orders) {
            comparing = comparing.thenComparing((nodeInfo1, nodeInfo2) -> {
                Object value1 = getValue(nodeInfo1, order.getField());
                Object value2 = getValue(nodeInfo2, order.getField());

                Comparable v1 = value1 instanceof Comparable ? (Comparable) value1 : null;
                Comparable v2 = value2 instanceof Comparable ? (Comparable) value2 : null;
                @SuppressWarnings("unchecked") int result = Comparables.compare(v1, v2);
                return order.getOrder() == ASC ? result : -result;
            });
        }

        final List<Criterion<T>> criterions = new ArrayList<>();
        if (StringUtils.hasText(criteria)) {
            criterions.add(fromPredicate(w -> {
                try {
                    SpelExpression expr = parser.parseRaw(criteria);
                    return (Boolean) expr.getValue(w);
                } catch (Exception e) {
                    log.error("error during parsing '" + criteria + "', '" + w + "'", e);
                    return false;
                }
            }));
        }

        criterions.add(topN(comparing, searchQuery.getPage() * searchQuery.getSize(), searchQuery.getSize()));

        final Criterion<T> compositeCriteria =
                criterions.stream().reduce(c -> c, (c1, c2) -> (s -> c2.apply(c1.apply(s))));

        return compositeCriteria.apply(collection.stream()).collect(Collectors.toList());
    }

    @FunctionalInterface
    private interface Criterion<T> {
        Stream<T> apply(Stream<T> s);
    }

    /**
     * Creates a Criterion that sorts the stream using a Comparator {@code cmp}
     * and then returns a stream of the first {@code n} elements of the result.
     */
    private <T> Criterion<T> topN(Comparator<T> cmp, long from, long size) {
        return stream -> stream.sorted(cmp).skip(from).limit(size);
    }

    /**
     * Creates a Criterion from a Predicate.
     */
    private <T> Criterion<T> fromPredicate(Predicate<T> pred) {
        return stream -> stream.filter(pred);
    }

}
