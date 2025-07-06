package org.example.studysearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchLog {
    private List<String> searchHistory;
    private Map<String, Integer> searchCount;
    private boolean isLocked;
    private int numUsages;
    private String logName;

    public SearchLog(String logName) {
        this.searchHistory = new ArrayList<>();
        this.searchCount = new HashMap<>();
        this.logName = logName;
        this.numUsages = 0;
        this.isLocked = false;
    }

    /**
     * Preferred method going forward – encapsulates all behavior.
     */
    public void addSearch(String searchQuery) {
        if (isLocked) {
            throw new IllegalStateException("Search log is locked. Cannot add new searches.");
        }
        searchHistory.add(searchQuery);
        searchCount.put(searchQuery, searchCount.getOrDefault(searchQuery, 0) + 1);
        numUsages++;
    }

    /**
     * Backward compatible method used by legacy code like GeneralSearch.
     */
    public void addSearchHistory(String searchQuery) {
        searchHistory.add(searchQuery);
        searchCount.put(searchQuery, searchCount.getOrDefault(searchQuery, 0) + 1);
    }

    public List<String> getSearchHistory() {
        return new ArrayList<>(searchHistory);
    }

    public void setSearchHistory(List<String> searchHistory) {
        this.searchHistory = searchHistory;
    }

    public Map<String, Integer> getSearchCount() {
        return new HashMap<>(searchCount);
    }

    public void setSearchCount(Map<String, Integer> searchCount) {
        this.searchCount = searchCount;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public int getNumUsages() {
        return numUsages;
    }

    public void setNumUsages(Integer numUsages) {
        this.numUsages = numUsages;
    }

    public String getLogName() {
        return logName;
    }

    public void setLogName(String logName) {
        this.logName = logName;
    }

    public void clearLog() {
        if (isLocked) {
            throw new IllegalStateException("Cannot clear a locked log.");
        }
        searchHistory.clear();
        searchCount.clear();
        numUsages = 0;
    }
}
