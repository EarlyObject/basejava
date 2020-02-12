package ru.javawebinar.basejava.model;

import java.util.List;
import java.util.Objects;

public class OrganizationSection implements Section {
    private final List<Organization> list;

    public OrganizationSection(List<Organization> list) {
        this.list = Objects.requireNonNull(list);
    }

    public List<Organization> getList() {
        return list;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Organization organization : list) {
            builder.append("* ")
                    .append(organization.toString());
        }
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrganizationSection)) return false;
        OrganizationSection that = (OrganizationSection) o;
        return Objects.equals(list, that.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
    }
}
