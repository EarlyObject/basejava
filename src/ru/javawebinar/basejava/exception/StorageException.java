package ru.javawebinar.basejava.exception;

public class StorageException extends RuntimeException {
    private final String UUID;

    public StorageException(String message, String UUID) {
        super(message);
        this.UUID = UUID;
    }

    public String getUUID() {
        return UUID;
    }
}
