package org.example.studyregistry;

import java.time.LocalDateTime;

public class TimeInfo {
    private final Integer practicedDays;
    private final LocalDateTime startDate;
    private final Double duration;

    public TimeInfo(Integer practicedDays, int day, int month, int year, Double duration) {
        this.practicedDays = practicedDays;
        this.duration = duration;
        this.startDate = LocalDateTime.of(year, month, day, 0, 0);
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
}
