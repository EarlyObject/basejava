package ru.javawebinar.basejava.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

import static ru.javawebinar.basejava.util.DateUtil.NOW;
import static ru.javawebinar.basejava.util.DateUtil.of;

public class Organization implements Serializable {
    private static final long serialVersionUID = -6160732475006319535L;
    private final Link homePage;
    private final String name;
    private final List<Position> positionList;
    private String url;

    public Organization(String name, List<Position> positionList) {
        this(name, null, positionList);
    }

    public Organization(String name, String url, List<Position> positionList) {
        this.homePage = new Link(name, url);
        this.name = Objects.requireNonNull(name);
        this.url = url;
        this.positionList = Objects.requireNonNull(positionList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        if (!Objects.equals(homePage, that.homePage)) return false;
        if (!name.equals(that.name)) return false;
        if (!Objects.equals(url, that.url)) return false;
        return positionList.equals(that.positionList);
    }

    @Override
    public int hashCode() {
        int result = homePage != null ? homePage.hashCode() : 0;
        result = 31 * result + name.hashCode();
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + positionList.hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(homePage)
                .append(System.lineSeparator());
        for (Position position : positionList) {
            builder.append(position.toString())
                    .append(System.lineSeparator());
        }
        builder.append(System.lineSeparator());
        return builder.toString();
    }

    public static class Position implements Serializable {
        private static final long serialVersionUID = 8628409555274508156L;
        private final LocalDate begin;
        private final LocalDate end;
        private String title;
        private String description;

  /*      public Position(LocalDate begin, LocalDate end) {
            this.begin = Objects.requireNonNull(begin);
            this.end = Objects.requireNonNull(end);
        }*/

        public Position(int startYear, Month startMonth, String title, String description) {
            this(of(startYear, startMonth), NOW, title, description);
        }

        public Position(int startYear, Month startMonth, int endYear, Month endMonth, String title, String description) {
            this(of(startYear, startMonth), of(endYear, endMonth), title, description);
        }

        public Position(LocalDate begin, LocalDate end, String title, String description) {
            this.begin = Objects.requireNonNull(begin);
            this.end = Objects.requireNonNull(end);
            this.title = Objects.requireNonNull(title);
            this.description = Objects.requireNonNull(description);
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        @Override
        public String toString() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yyyy");
            return begin.format(formatter) +
                    "-" +
                    end.format(formatter) +
                    " " +
                    title +
                    System.lineSeparator() +
                    (description != null ? description : "");
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position that = (Position) o;
            return Objects.equals(begin, that.begin) &&
                    Objects.equals(end, that.end) &&
                    Objects.equals(title, that.title) &&
                    Objects.equals(description, that.description);
        }

        @Override
        public int hashCode() {
            return Objects.hash(begin, end, title, description);
        }
    }
}
