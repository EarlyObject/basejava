package ru.javawebinar.basejava.model;

import java.util.ArrayList;
import java.util.List;

public class ListSection implements Section {
    protected List<String> list = new ArrayList<>();

    public List<String> getList() {
        return list;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (String s: list) {
          builder.append("* ").append(s).append("\n");
        }
        builder.append(System.lineSeparator());
        return builder.toString();
    }


}
