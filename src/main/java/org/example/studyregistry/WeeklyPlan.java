package org.example.studyregistry;

import java.util.List;

public class WeeklyPlan {
    private final String planName;
    private final String objectiveTitle;
    private final String objectiveDescription;
    private final String materialTopic;
    private final String materialFormat;
    private final String goal;
    private final String reminderTitle;
    private final String reminderDescription;
    private final String mainTaskTitle;
    private final String mainHabit;
    private final String mainCardStudy;

    private WeeklyPlan(Builder builder) {
        this.planName = builder.planName;
        this.objectiveTitle = builder.objectiveTitle;
        this.objectiveDescription = builder.objectiveDescription;
        this.materialTopic = builder.materialTopic;
        this.materialFormat = builder.materialFormat;
        this.goal = builder.goal;
        this.reminderTitle = builder.reminderTitle;
        this.reminderDescription = builder.reminderDescription;
        this.mainTaskTitle = builder.mainTaskTitle;
        this.mainHabit = builder.mainHabit;
        this.mainCardStudy = builder.mainCardStudy;
    }

    public static class Builder {
        private String planName;
        private String objectiveTitle;
        private String objectiveDescription;
        private String materialTopic;
        private String materialFormat;
        private String goal;
        private String reminderTitle;
        private String reminderDescription;
        private String mainTaskTitle;
        private String mainHabit;
        private String mainCardStudy;

        public Builder planName(String planName) {
            this.planName = planName;
            return this;
        }

        public Builder objective(String title, String description) {
            this.objectiveTitle = title;
            this.objectiveDescription = description;
            return this;
        }

        public Builder material(String topic, String format) {
            this.materialTopic = topic;
            this.materialFormat = format;
            return this;
        }

        public Builder goal(String goal) {
            this.goal = goal;
            return this;
        }

        public Builder reminder(String title, String description) {
            this.reminderTitle = title;
            this.reminderDescription = description;
            return this;
        }

        public Builder mainTask(String taskTitle, String habit, String cardStudy) {
            this.mainTaskTitle = taskTitle;
            this.mainHabit = habit;
            this.mainCardStudy = cardStudy;
            return this;
        }

        public WeeklyPlan build() {
            return new WeeklyPlan(this);
        }
    }

    // --- Business Logic Methods ---

    public boolean hasValidGoal() {
        return goal != null && !goal.isBlank() && goal.length() >= 5;
    }

    public boolean isMaterialVideoBased() {
        return "video".equalsIgnoreCase(materialFormat);
    }

    public boolean isReminderSet() {
        return reminderTitle != null && !reminderTitle.isBlank();
    }

    public boolean hasCompleteObjective() {
        return objectiveTitle != null && objectiveDescription != null
                && !objectiveTitle.isBlank() && !objectiveDescription.isBlank();
    }

    public boolean isReadyToAssign() {
        return hasCompleteObjective()
                && hasValidGoal()
                && isReminderSet()
                && mainTaskTitle != null && !mainTaskTitle.isBlank();
    }

    public int calculatePlanScore() {
        int score = 0;
        score += scoreForObjective();
        score += scoreForGoal();
        score += scoreForMaterialFormat();
        score += scoreForReminder();
        score += scoreForHabit();
        score += scoreForCardStudy();
        return score;
    }

    private int scoreForObjective() {
        return hasCompleteObjective() ? 2 : 0;
    }

    private int scoreForGoal() {
        return hasValidGoal() ? 2 : 0;
    }

    private int scoreForMaterialFormat() {
        return isMaterialVideoBased() ? 1 : 0;
    }

    private int scoreForReminder() {
        return isReminderSet() ? 1 : 0;
    }

    private int scoreForHabit() {
        return (mainHabit != null && !mainHabit.isBlank()) ? 1 : 0;
    }

    private int scoreForCardStudy() {
        return (mainCardStudy != null && !mainCardStudy.isBlank()) ? 1 : 0;
    }

    public String getPlanStatusLabel() {
        int score = calculatePlanScore();
        if (score >= 7) return "Excellent";
        if (score >= 5) return "Good";
        if (score >= 3) return "Average";
        return "Incomplete";
    }

    public String getSummary() {
        return String.format(
                "Plan: %s | Goal: %s | Material: %s (%s) | Task: %s | Status: %s",
                planName, goal, materialTopic, materialFormat, mainTaskTitle, getPlanStatusLabel()
        );
    }

    public List<String> toList() {
        return List.of(
                planName,
                objectiveTitle,
                objectiveDescription,
                materialTopic,
                materialFormat,
                goal,
                reminderTitle,
                reminderDescription,
                mainTaskTitle,
                mainHabit,
                mainCardStudy
        );
    }

    public static WeeklyPlan fromList(List<String> props) {
        validateListSize(props);
        return extractBuilderFromList(props).build();
    }

    private static void validateListSize(List<String> props) {
        if (props == null || props.size() != 11) {
            throw new IllegalArgumentException("Expected 11 elements for WeeklyPlan");
        }
    }

    private static Builder extractBuilderFromList(List<String> props) {
        return new Builder()
                .planName(props.get(0))
                .objective(props.get(1), props.get(2))
                .material(props.get(3), props.get(4))
                .goal(props.get(5))
                .reminder(props.get(6), props.get(7))
                .mainTask(props.get(8), props.get(9), props.get(10));
    }

    // --- Optional Getters ---

    public String getPlanName() {
        return planName;
    }

    public String getGoal() {
        return goal;
    }

    public String getMainTaskTitle() {
        return mainTaskTitle;
    }

    // Add more getters if needed
}
