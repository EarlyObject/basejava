package ru.javawebinar.basejava.model;

import java.util.List;
import java.util.Objects;

public class ListSection implements Section {
    protected final List<String> list;

    public ListSection(List<String> list) {
        this.list = Objects.requireNonNull(list);
    }

    public List<String> getList() {
        return list;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (String s: list) {
          builder.append("* ")
                  .append(s)
                  .append(System.lineSeparator());
        }
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListSection)) return false;
        ListSection that = (ListSection) o;
        return Objects.equals(list, that.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
    }
}
