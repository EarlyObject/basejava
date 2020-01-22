package ru.javawebinar.basejava.exception;

public class NotExistStorageException extends StorageException {

    public NotExistStorageException(String UUID) {
        super("RESUME " + UUID + " DOES NOT EXIST", UUID);
    }

}
