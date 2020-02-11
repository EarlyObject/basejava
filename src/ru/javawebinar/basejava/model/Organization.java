package ru.javawebinar.basejava.model;

public class Organization {
    private String name;
    private String URL;

    public Organization(String name) {
        this.name = name;
    }

    public Organization(String name, String URL) {
        this.name = name;
        this.URL = URL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    @Override
    public String toString() {
        return name + " " + URL;
    }
}
