package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractFileStorage extends AbstractStorage<File> {
    private File directory;

    protected AbstractFileStorage(File directory) {
        Objects.requireNonNull(directory, "directory must not be null");
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not directory");
        }
        if (!directory.canRead() || !directory.canWrite()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not readable/writable");
        }
        this.directory = directory;
    }

    protected void saveImpl(File file, Resume resume) {
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new StorageException("Create operation error", file.getName(), e);
        }
        updateImpl(file, resume);
    }

    protected abstract void doWrite(Resume resume, File file) throws IOException;

    @Override
    protected Resume getImpl(File file) {
        try {
            return doRead(file);
        } catch (IOException e) {
            throw new StorageException("Read operation error", file.getName(), e);
        }
    }

    protected abstract Resume doRead(File file) throws IOException;

    @Override
    protected void updateImpl(File file, Resume resume) {
        try {
            doWrite(resume, file);
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
    protected List<Resume> getAll() {
        List<Resume> returnValue = new ArrayList<>();
        if (directory == null) {
            throw new StorageException("Directory is null", null);
        } else {
            for (File file : Objects.requireNonNull(directory.listFiles())) {
                returnValue.add(getImpl(file));
            }
        }
        return returnValue;
    }

    @Override
    public int size() {
        if (directory == null) {
            throw new StorageException("Directory is null", null);
        }
        return Objects.requireNonNull(directory.list()).length;
    }

    @Override
    public void clear() {
        if (directory == null) {
            throw new StorageException("Directory is null", null);
        } else {
            for (File file : Objects.requireNonNull(directory.listFiles())) {
                deleteImpl(file);
            }
        }
    }
}
