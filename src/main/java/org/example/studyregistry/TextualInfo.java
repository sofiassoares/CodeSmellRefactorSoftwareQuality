package org.example.studyregistry;

import java.util.Objects;

public final class TextualInfo {
    private final String title;
    private final String description;
    private final String topic;
    private final String objectiveInOneLine;
    private final String objectiveFullDescription;
    private final String motivation;

    // Private constructor
    private TextualInfo(String title, String description, String topic,
                        String objectiveInOneLine, String objectiveFullDescription, String motivation) {
        this.title = title;
        this.description = description;
        this.topic = topic;
        this.objectiveInOneLine = objectiveInOneLine;
        this.objectiveFullDescription = objectiveFullDescription;
        this.motivation = motivation;
    }

    // Static factory method for safe creation
    public static TextualInfo from(String title, String description, String topic,
                                   String objectiveInOneLine, String objectiveFullDescription, String motivation) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title must not be null or blank");
        }
        return new TextualInfo(
                title.trim(),
                description != null ? description.trim() : "",
                topic != null ? topic.trim() : "",
                objectiveInOneLine != null ? objectiveInOneLine.trim() : "",
                objectiveFullDescription != null ? objectiveFullDescription.trim() : "",
                motivation != null ? motivation.trim() : ""
        );
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getTopic() {
        return topic;
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

    // Behavior methods
    public boolean containsKeyword(String keyword) {
        if (keyword == null || keyword.isBlank()) {
            return false;
        }
        return title.contains(keyword)
                || description.contains(keyword)
                || topic.contains(keyword)
                || objectiveInOneLine.contains(keyword)
                || objectiveFullDescription.contains(keyword)
                || motivation.contains(keyword);
    }

    public String summarize() {
        return String.format("[%s] %s", title,
                (objectiveInOneLine != null && !objectiveInOneLine.isBlank())
                        ? objectiveInOneLine
                        : "No summary available");
    }

    // Equality methods
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof TextualInfo other)) return false;
        return Objects.equals(title, other.title)
                && Objects.equals(description, other.description)
                && Objects.equals(topic, other.topic)
                && Objects.equals(objectiveInOneLine, other.objectiveInOneLine)
                && Objects.equals(objectiveFullDescription, other.objectiveFullDescription)
                && Objects.equals(motivation, other.motivation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, topic, objectiveInOneLine, objectiveFullDescription, motivation);
    }
}
