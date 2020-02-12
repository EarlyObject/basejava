package ru.javawebinar.basejava.model;

import java.util.List;
import java.util.Objects;

public class Organization {
    private final String name;
    private String url;
    private final List<TimeInterval> timeIntervalList;

    public Organization(String name, List<TimeInterval> timeIntervalList) {
        this(name, null, timeIntervalList);
    }

    public Organization(String name, String url, List<TimeInterval> timeIntervalList) {
        this.name = Objects.requireNonNull(name);
        this.url = url;
        this.timeIntervalList = Objects.requireNonNull(timeIntervalList);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name)
                .append(" ")
                .append(url)
                .append(System.lineSeparator());
        for (TimeInterval timeInterval : timeIntervalList) {
            builder.append(timeInterval.toString())
                    .append(System.lineSeparator());
        }
        builder.append(System.lineSeparator());
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(url, that.url) &&
                Objects.equals(timeIntervalList, that.timeIntervalList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, url, timeIntervalList);
    }
}
