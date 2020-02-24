package ru.javawebinar.basejava.model;

public enum ContactType {
    PHONE_NUMBER("Тел."),
    SKYPE("Skype"),
    EMAIL("Почта"),
    LINKEDIN_PROFILE("Профиль LinkedIn"),
    GITHUB_PROFILE("Профиль GitHub"),
    STACKOVERFLOW_PROFILE("Профиль StackOverflow"),
    WEBPAGE("Домашняя страница");

    private String title;

    public String getTitle() {
        return title;
    }

    ContactType(String title) {
        this.title = title;
    }
}
