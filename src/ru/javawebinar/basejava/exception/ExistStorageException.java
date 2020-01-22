package ru.javawebinar.basejava.exception;

public class ExistStorageException extends StorageException {

    public ExistStorageException(String UUID) {
        super("RESUME " + UUID + " ALREADY EXISTS", UUID);
    }
}
