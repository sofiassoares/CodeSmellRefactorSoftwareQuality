package org.example.studyregistry;

import java.time.LocalDateTime;
import java.util.List;

public class StudyObjective extends Registry {
    private String title;
    private String description;
    private String topic;
    private Integer practicedDays;
    private LocalDateTime startDate;
    private Double duration;
    private String objectiveInOneLine;
    private String objectiveFullDescription;
    private String motivation;

    public StudyObjective(String title, String description) {
        this.title = title;
        this.description = description;
        this.name = title;
    }

    public void handleSetRegistry(Integer id, String name, Integer priority, boolean isActive) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.isActive = isActive;
    }

    public void handleSetTextualInfo(TextualInfo info) {
        this.title = info.getTitle();
        this.description = info.getDescription();
        this.topic = info.getTopic();
        this.objectiveInOneLine = info.getObjectiveInOneLine();
        this.objectiveFullDescription = info.getObjectiveFullDescription();
        this.motivation = info.getMotivation();
    }

    public void handleSetTime(TimeInfo info) {
        this.practicedDays = info.getPracticedDays();
        this.startDate = info.getStartDate();
        this.duration = info.getDuration();
    }

    public void handleSetObjective(Integer id, Integer priority, String name, boolean isActive,
                                   TextualInfo textualInfo, TimeInfo timeInfo) {
        handleSetRegistry(id, name, priority, isActive);
        handleSetTextualInfo(textualInfo);
        handleSetTime(timeInfo);
    }

    public int handleSetObjectiveAdapter(List<Integer> intProps, List<String> stringProps, Double duration, boolean isActive) {
        // Map stringProps:
        // 0 - name (for Registry)
        // 1 - title
        // 2 - description
        // 3 - topic
        // 4 - objectiveInOneLine
        // 5 - objectiveFullDescription
        // 6 - motivation

        TextualInfo txtInfo = TextualInfo.from(
                stringProps.get(1), // title
                stringProps.get(2), // description
                stringProps.get(3), // topic
                stringProps.get(4), // objectiveInOneLine
                stringProps.get(5), // objectiveFullDescription
                stringProps.get(6)  // motivation
        );

        TimeInfo timeInfo = new TimeInfo(
                intProps.get(2), // practicedDays
                intProps.get(3), // day
                intProps.get(4), // month
                intProps.get(5), // year
                duration
        );

        handleSetObjective(
                intProps.get(0),      // id
                intProps.get(1),      // priority
                stringProps.get(0),   // name (Registry.name)
                isActive,
                txtInfo,
                timeInfo
        );
        return intProps.get(0);
    }

    public String getTitle() {
        return title;
    }

    public String getTopic() {
        return topic;
    }

    public Integer getPracticedDays() {
        return practicedDays;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public Double getDuration() {
        return duration;
    }

    public String getObjectiveInOneLine() {
        return objectiveInOneLine;
    }

    public String getObjectiveFullDescription() {
        return objectiveFullDescription;
    }

    public String getMotivation() {
        return motivation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "StudyObjective [title:" + title
                + ", description:" + description
                + (topic != null ? ", topic:" + topic : "")
                + (practicedDays != null ? ", practicedDays:" + practicedDays : "")
                + (duration != null ? ", duration:" + duration : "")
                + (objectiveInOneLine != null ? ", objective summary:" + objectiveInOneLine : "")
                + (objectiveFullDescription != null ? ", objective full description:" + objectiveFullDescription : "")
                + (motivation != null ? ", motivation:" + motivation : "")
                + "]";
    }
}
