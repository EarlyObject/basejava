package ru.javawebinar.basejava.model;

import java.util.Objects;

public class TextSection extends Section {
    private static final long serialVersionUID = 4350149971013056341L;
    public final String text;

    public TextSection(String text) {
        this.text = Objects.requireNonNull(text);
    }

    @Override
    public String toString() {
        return text + System.lineSeparator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextSection that = (TextSection) o;
        return Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }
}
