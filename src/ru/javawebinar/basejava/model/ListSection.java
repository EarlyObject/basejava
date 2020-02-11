package ru.javawebinar.basejava.model;

import java.util.ArrayList;
import java.util.List;

public class ListSection implements Section {
    protected List<String> listOfFields = new ArrayList<>();

    public List<String> getListOfFields() {
        return listOfFields;
    }

    @Override
    public String toString() {
        return listOfFields.toString();
    }
}
