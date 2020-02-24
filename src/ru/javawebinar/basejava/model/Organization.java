package ru.javawebinar.basejava.model;

import java.util.List;
import java.util.Objects;

public class Organization {
    private final Link homePage;
    private final String name;
    private String url;
    private final List<TimeInterval> timeIntervalList;

    public Organization(String name, List<TimeInterval> timeIntervalList) {
        this(name, null, timeIntervalList);
    }

    public Organization(String name, String url, List<TimeInterval> timeIntervalList) {
        this.homePage = new Link(name, url);
        this.name = Objects.requireNonNull(name);
        this.url = url;
        this.timeIntervalList = Objects.requireNonNull(timeIntervalList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        if (!Objects.equals(homePage, that.homePage)) return false;
        if (!name.equals(that.name)) return false;
        if (!Objects.equals(url, that.url)) return false;
        return timeIntervalList.equals(that.timeIntervalList);
    }

    @Override
    public int hashCode() {
        int result = homePage != null ? homePage.hashCode() : 0;
        result = 31 * result + name.hashCode();
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + timeIntervalList.hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(homePage)
                .append(System.lineSeparator());
        for (TimeInterval timeInterval : timeIntervalList) {
            builder.append(timeInterval.toString())
                    .append(System.lineSeparator());
        }
        builder.append(System.lineSeparator());
        return builder.toString();
    }

}
