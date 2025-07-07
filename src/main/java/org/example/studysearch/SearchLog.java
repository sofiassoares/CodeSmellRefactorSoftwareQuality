package org.example.studysearch;

import org.example.studyregistry.StudyMaterial;

import java.util.ArrayList;
import java.util.List;

public class SearchLog {
    private String label;
    private List<String> log = new ArrayList<>();

    public SearchLog(String label) {
        this.label = label;
    }

    public void addSearchHistory(String query) {
        log.add("[" + label + "] Searched for: " + query);
    }

    public List<String> getSearchHistory() {
        return new ArrayList<>(log);
    }

    public int getNumUsages() {
        return log.size();
    }

    public String getLogName() {
        return label;
    }

    public String getLastSearchEntry() {
        return log.isEmpty() ? null : log.get(log.size() - 1);
    }

    public List<String> performSearch(String text, List<String> coreResults) {
        List<String> results = new ArrayList<>(coreResults);
        addSearchHistory(text);
        String lastEntry = getLastSearchEntry();
        if (lastEntry != null) {
            results.add(lastEntry);
        }
        return results;
    }

    // Optional: shortcut for MaterialSearch (if used)
    public List<String> performMaterialSearch(String text) {
        List<String> materialResults = StudyMaterial.getStudyMaterial().searchInMaterials(text);
        return performSearch(text, materialResults);
    }
}
