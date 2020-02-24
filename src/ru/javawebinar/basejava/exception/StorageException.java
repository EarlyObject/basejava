package ru.javawebinar.basejava.exception;

import java.io.IOException;

public class StorageException extends RuntimeException {
    private final String UUID;

    public StorageException(String message, String UUID) {
        super(message);
        this.UUID = UUID;
    }

    public StorageException(String message, String uuid, IOException e) {
        super(message);
        this.UUID = uuid;
    }

    public String getUUID() {
        return UUID;
    }
}
