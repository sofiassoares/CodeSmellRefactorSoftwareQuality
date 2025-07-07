package org.example.studysearch;

import java.util.ArrayList;
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

    // ✅ Replace with your actual search logic
    private List<String> handleSearch(String text) {
        List<String> coreResults = performGeneralSearchLogic(text);
        return searchLog.performSearch(text, coreResults);
    }

    private List<String> performGeneralSearchLogic(String text) {
        // Stub logic — replace this with real search implementation
        List<String> dummyResults = new ArrayList<>();
        if (text.toLowerCase().contains("example")) {
            dummyResults.add("Example match found");
        }
        return dummyResults;
    }
}
