package ru.javawebinar.basejava.model;

import java.util.Objects;
import java.util.UUID;

public class Resume implements Comparable<Resume> {
    private String fullName;
    private String uuid;

    public Resume(String fullName) {
        this (fullName, UUID.randomUUID().toString());
    }

    public Resume(String fullName, String uuid) {
        this.fullName = Objects.requireNonNull(fullName, "fullName must not be null");
        this.uuid = Objects.requireNonNull(uuid, "uuid must not be null");
    }

    public String getUuid() {
        return uuid;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resume resume = (Resume) o;
        return fullName.equals(resume.fullName) &&
                uuid.equals(resume.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, uuid);
    }

    @Override
    public String toString() {
        return "Resume{" +
                "fullName='" + fullName + '\'' +
                ", uuid='" + uuid + '\'' +
                '}';
    }

    @Override
    public int compareTo(Resume o) {
        return uuid.compareTo(o.getUuid());
    }
}