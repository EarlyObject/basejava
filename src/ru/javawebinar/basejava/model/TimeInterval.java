package ru.javawebinar.basejava.model;

import java.time.LocalDate;

public class TimeInterval {
    private LocalDate beginning;
    private LocalDate end;
    private String description;


    public TimeInterval(LocalDate beginning, LocalDate end) {
        this.beginning = beginning;
        this.end = end;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return beginning + " - " + end + " " + description;
    }
}
