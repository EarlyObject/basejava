package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.io.*;
import java.nio.file.Files;

public class AbstractFileStorage<SK> extends FilePathContext<File> {

    protected AbstractFileStorage(File directory) {
        super(directory);
    }

    protected void saveImpl(File file, Resume resume) {
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new StorageException("Create operation error", file.getName(), e);
        }
        updateImpl(file, resume);
    }

    @Override
    protected Resume getImpl(File file) {
        try {
            return objectStream.doRead(Files.newInputStream(file.toPath()));
        } catch (IOException e) {
            throw new StorageException("Read operation error", file.getName(), e);
        }
    }

    @Override
    protected void updateImpl(File file, Resume resume) {
        try {
            objectStream.doWrite(resume, Files.newOutputStream(file.toPath()));
        } catch (IOException e) {
            throw new StorageException("Update operation error", file.getName(), e);
        }
    }

    @Override
    protected void deleteImpl(File file) {
        if (!file.delete()) {
            throw new StorageException("Delete operation failed", file.getName());
        }
    }

    @Override
    protected File getSearchKey(String uuid) {
        return new File(directory, uuid);
    }

    @Override
    protected Boolean isSearchKeyValid(File file) {
        return file.exists();
    }

    @Override
    protected File converter(File file) {
        return file;
    }


}
