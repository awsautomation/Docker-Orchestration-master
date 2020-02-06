
package com.codeabovelab.dm.cluman.cluster.registry;

import com.codeabovelab.dm.cluman.cluster.registry.data.SearchResult;

public interface SupportSearch {
    SearchResult search(String searchTerm, int page, int count);
}
