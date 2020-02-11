package ru.javawebinar.basejava.model;

import java.util.Objects;

public class TextSection implements Section {

    public String textField;

    public TextSection(String textField) {
        this.textField = Objects.requireNonNull(textField);
    }

    @Override
    public String toString() {
        return textField;
    }
}
