package ru.javawebinar.basejava.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class OrganizationSection implements Section {
   private Map<TimeInterval, Organization> organizationMap = new LinkedHashMap<>();

    public Map<TimeInterval, Organization> getOrganizationMap() {
        return organizationMap;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (Map.Entry<TimeInterval, Organization> entry : organizationMap.entrySet()) {
           builder.append(entry.getKey().toString()).append(System.getProperty("line.separator"));
           builder.append(entry.getValue().toString()).append(System.getProperty("line.separator"));
            System.out.println();
        }

        builder.append(System.lineSeparator());
        return builder.toString();
    }
}
