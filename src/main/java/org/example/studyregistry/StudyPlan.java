package org.example.studyregistry;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudyPlan extends Registry {
    private StudyObjective objective;
    private List<String> steps;

    public StudyPlan(String planName, StudyObjective objective, List<StudyMaterial> materials) {
        this.name = planName;
        this.objective = objective;
        this.steps = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Plan: " + name + ",\nObjective: " + objective.getDescription() +
                ",\nSteps: " + String.join(", ", steps);
    }

    public List<String> getSteps() {
        return steps;
    }

    public StudyObjective getObjective() {
        return objective;
    }

    public void assignObjective(StudyObjective objective) {
        this.objective = objective;
    }

    public void addSingleStep(String toAdd) {
        steps.add(toAdd);
    }

    public void assignStepsFromInputs(List<String> stringProperties, Integer numberOfSteps,
                                      boolean isImportant, LocalDateTime startDate, LocalDateTime endDate) {
        this.steps = generateSteps(stringProperties, numberOfSteps, isImportant, startDate, endDate);
    }

    public void handleAssignSteps(List<String> stringProperties, Integer numberOfSteps,
                                  boolean isImportant, LocalDateTime startDate, LocalDateTime endDate) {
        assignStepsFromInputs(stringProperties, numberOfSteps, isImportant, startDate, endDate);
    }

    private List<String> generateSteps(List<String> props, Integer numberOfSteps, boolean isImportant,
                                       LocalDateTime startDate, LocalDateTime endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        return new ArrayList<>(Arrays.asList(
                props.get(0),  // firstStep
                props.get(1),  // resetStudyMechanism
                props.get(2),  // consistentStep
                props.get(3),  // seasonalSteps
                props.get(4),  // basicSteps
                "Number of steps: " + numberOfSteps,
                "Is it important to you? " + isImportant,
                startDate.format(formatter),
                endDate.format(formatter),
                props.get(5),  // mainObjectiveTitle
                props.get(6),  // mainGoalTitle
                props.get(7),  // mainMaterialTopic
                props.get(8)   // mainTask
        ));
    }
}
