package org.example.studysearch;

import org.example.studycards.CardManager;
import org.example.studyplanner.HabitTracker;
import org.example.studyplanner.TodoTracker;
import org.example.studyregistry.StudyMaterial;
import org.example.studyregistry.StudyTaskManager;

import java.util.ArrayList;
import java.util.List;

public class SearchLog {
    private String logName;
    private List<String> history = new ArrayList<>();
    private int numUsages = 0;

    public SearchLog(String logName) {
        this.logName = logName;
    }

    public void addSearchHistory(String entry) {
        history.add(entry);
        numUsages++;
    }

    public String getLastSearchEntry() {
        return history.isEmpty() ? null : history.get(history.size() - 1);
    }

    public String logSearchAndReturnEntry(String entry) {
        addSearchHistory(entry);
        return getLastSearchEntry();
    }

    public List<String> getSearchHistory() {
        return new ArrayList<>(history);
    }

    public int getNumUsages() {
        return numUsages;
    }

    public String getLogName() {
        return logName;
    }

    // ✅ General Search - searches all sources
    public List<String> performGeneralSearch(String text) {
        List<String> results = new ArrayList<>();

        results.addAll(CardManager.getCardManager().searchInCards(text));
        results.addAll(HabitTracker.getHabitTracker().searchInHabits(text));
        results.addAll(TodoTracker.getInstance().searchInTodos(text));
        results.addAll(StudyMaterial.getStudyMaterial().searchInMaterials(text));
        results.addAll(StudyTaskManager.getStudyTaskManager().searchInRegistries(text));

        logSearchAndReturnEntry(text);
        results.add(getLogName());

        return results;
    }

    // ✅ Registry-specific Search
    public List<String> performRegistrySearch(String text) {
        List<String> results = new ArrayList<>();

        results.addAll(CardManager.getCardManager().searchInCards(text));
        results.addAll(HabitTracker.getHabitTracker().searchInHabits(text));
        results.addAll(TodoTracker.getInstance().searchInTodos(text));
        results.addAll(StudyTaskManager.getStudyTaskManager().searchInRegistries(text));

        logSearchAndReturnEntry(text);
        results.add(getLogName());

        return results;
    }

    // ✅ Material-specific Search
    public List<String> performMaterialSearch(String text) {
        List<String> results = StudyMaterial.getStudyMaterial().searchInMaterials(text);

        logSearchAndReturnEntry(text);
        results.add(getLogName());

        return results;
    }

    // ✅ Reusable method for cases where core results are computed externally
    public List<String> performSearch(String text, List<String> coreResults) {
        logSearchAndReturnEntry(text);
        List<String> results = new ArrayList<>(coreResults);
        results.add(getLogName());
        return results;
    }
}
