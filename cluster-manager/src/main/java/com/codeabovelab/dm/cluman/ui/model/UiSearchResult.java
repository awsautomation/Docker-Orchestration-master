
package com.codeabovelab.dm.cluman.ui.model;

import com.codeabovelab.dm.cluman.cluster.registry.data.SearchResult;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 */
@Value
@Builder
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
public class UiSearchResult {
    private final int totalPages;
    private final int totalResults;
    private final int pageSize;
    private final int page;
    private final String query;
    private final List<Result> results;

    @Value
    @Builder
    @AllArgsConstructor(onConstructor = @__(@JsonCreator))
    public static class Result {
        private final String name;
        private final String description;
        private final Collection<String> registries;

        public static Result from(SearchResult.Result res) {
            return Result.builder()
                    .name(res.getName())
                    .description(res.getDescription())
                    .registries(res.getRegistries())
                    .build();
        }
    }

    public static UiSearchResult from(SearchResult res) {
        return UiSearchResult.builder()
                .totalPages(res.getNumPages())
                .totalResults(res.getNumResults())
                .pageSize(res.getPageSize())
                .page(res.getPage())
                .query(res.getQuery())
                .results(res.getResults().stream().map(Result::from).collect(Collectors.toList()))
                .build();
    }

}
