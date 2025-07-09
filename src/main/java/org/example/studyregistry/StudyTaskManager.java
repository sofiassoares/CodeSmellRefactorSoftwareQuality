package org.example.studyregistry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudyTaskManager {
    private static StudyTaskManager instance;
    private StudyMaterial studyMaterial = StudyMaterial.getStudyMaterial(); // Assuming this exists
    private List<Registry> registryList;
    private List<String> weekResponsibilities = List.of();

    private StudyTaskManager() {
        this.registryList = new ArrayList<>();
    }

    public static StudyTaskManager getStudyTaskManager() {
        if (instance == null) {
            instance = new StudyTaskManager();
        }
        return instance;
    }

    public List<String> getWeekResponsibilities() {
        return weekResponsibilities;
    }

    public void setUpWeek(WeeklyPlan plan) {
        this.weekResponsibilities = new ArrayList<>(plan.toList());
    }

    public void handleSetUpWeek(List<String> stringProperties) {
        WeeklyPlan plan = WeeklyPlan.fromList(stringProperties);
        setUpWeek(plan);
    }

    public void printWeeklySummary() {
        WeeklyPlan plan = WeeklyPlan.fromList(weekResponsibilities);
        System.out.println(plan.getSummary());
    }

    public void addRegistry(Registry registry) {
        registryList.add(registry);
    }

    public void removeRegistry(Registry registry) {
        registryList.remove(registry);
    }

    public List<Registry> getRegistryList() {
        return registryList;
    }

    public List<String> searchInRegistries(String text) {
        List<String> response = new ArrayList<>();
        for (Registry registry : registryList) {
            String name = (registry.getName() != null) ? registry.getName() : "";
            if (name.toLowerCase().contains(text.toLowerCase())) {
                response.add(registry.getName());
            }
        }
        return response;
    }
}
