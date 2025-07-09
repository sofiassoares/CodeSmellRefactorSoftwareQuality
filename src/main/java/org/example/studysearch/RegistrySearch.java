package org.example.studysearch;

import java.util.List;

public class RegistrySearch implements Search<String> {
    private SearchLog searchLog = new SearchLog("Registry Search");

    public RegistrySearch() {}

    @Override
    public List<String> search(String text) {
        // Delegate search logic to SearchLog
        return searchLog.performRegistrySearch(text);
    }

    public SearchLog getSearchLog() {
        return searchLog;
    }

    // Kept for compatibility
    public List<String> handleRegistrySearch(String text) {
        return search(text); // delegate call
    }
}
