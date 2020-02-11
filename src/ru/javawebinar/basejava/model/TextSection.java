package ru.javawebinar.basejava.model;

import java.util.Objects;

public class TextSection implements Section {
    public String text;

    public TextSection(String text) {
        this.text = Objects.requireNonNull(text);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(text).append(System.lineSeparator());
        return builder.toString();
    }
}
