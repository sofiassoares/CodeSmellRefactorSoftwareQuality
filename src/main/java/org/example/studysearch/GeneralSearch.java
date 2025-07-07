package org.example.studysearch;

import java.util.List;

public class GeneralSearch implements Search<String> {
    private SearchLog searchLog = new SearchLog("General Search");

    public GeneralSearch() {}

    @Override
    public List<String> search(String text) {
        return handleSearch(text);
    }

    public SearchLog getSearchLog() {
        return searchLog;
    }

    // Retained for compatibility, but now delegates to SearchLog
    private List<String> handleSearch(String text) {
        return searchLog.performSearch(text);
    }
}
