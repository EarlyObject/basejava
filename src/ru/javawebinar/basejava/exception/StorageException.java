package ru.javawebinar.basejava.exception;

public class StorageException extends RuntimeException {
    private final String UUID;

    public StorageException(String message, String UUID) {
        super(message);
        this.UUID = UUID;
    }

    public StorageException(String message, String uuid, Exception e) {
        super(message);
        this.UUID = uuid;
    }

    public StorageException(String message, Exception e) {
        this(message, null, e);
    }

    public StorageException(String message) {
        this(message, null, null);
    }

    public String getUUID() {
        return UUID;
    }
}
