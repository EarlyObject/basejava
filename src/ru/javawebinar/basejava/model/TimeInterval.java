package ru.javawebinar.basejava.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class TimeInterval {
    private final LocalDate begin;
    private final LocalDate end;
    private String position;
    private String description;

    public TimeInterval(LocalDate begin, LocalDate end) {
        this.begin = Objects.requireNonNull(begin);
        this.end = Objects.requireNonNull(end);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yyyy");
        return begin.format(formatter) +
                "-" +
                end.format(formatter) +
                " " +
                position +
                System.lineSeparator() +
                (description != null ? description : "");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeInterval that = (TimeInterval) o;
        return Objects.equals(begin, that.begin) &&
                Objects.equals(end, that.end) &&
                Objects.equals(position, that.position) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(begin, end, position, description);
    }
}
