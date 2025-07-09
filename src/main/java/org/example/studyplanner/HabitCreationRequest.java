package org.example.studyplanner;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class HabitCreationRequest {
    private String name;
    private String motivation;
    private Integer dailyMinutesDedication;
    private Integer dailyHoursDedication;
    private Integer year;
    private Integer month;
    private Integer day;
    private Integer hour;
    private Integer minute;
    private Integer seconds;
    private Boolean isConcluded;

    private HabitCreationRequest() {}

    public String getName() { return name; }
    public String getMotivation() { return motivation; }
    public Boolean getIsConcluded() { return isConcluded; }

    public LocalTime getDedicationTime() {
        return LocalTime.of(dailyHoursDedication, dailyMinutesDedication);
    }

    public LocalDateTime getStartDate() {
        return LocalDateTime.of(year, month, day, hour, minute, seconds);
    }

    public static class Builder {
        private final HabitCreationRequest request;

        public Builder() {
            request = new HabitCreationRequest();
        }

        public Builder withName(String name) {
            request.name = name;
            return this;
        }

        public Builder withMotivation(String motivation) {
            request.motivation = motivation;
            return this;
        }

        public Builder withDailyMinutesDedication(Integer minutes) {
            request.dailyMinutesDedication = minutes;
            return this;
        }

        public Builder withDailyHoursDedication(Integer hours) {
            request.dailyHoursDedication = hours;
            return this;
        }

        public Builder withDateTime(int year, int month, int day, int hour, int minute, int seconds) {
            request.year = year;
            request.month = month;
            request.day = day;
            request.hour = hour;
            request.minute = minute;
            request.seconds = seconds;
            return this;
        }

        public Builder withIsConcluded(Boolean isConcluded) {
            request.isConcluded = isConcluded;
            return this;
        }

        public HabitCreationRequest build() {
            return request;
        }
    }
}
