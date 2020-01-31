package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10000;
    protected int size = 0;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];

    protected abstract void specificSaveImplementation(Resume resume, int index);

    protected abstract void specificDeleteImplementation(Integer index);

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    @Override
    protected void saveImpl(Resume resume, Integer index) {
        if (size < STORAGE_LIMIT) {
            specificSaveImplementation(resume, index);
            size++;
        } else {
            throw new StorageException("FAILURE!!! THE STORAGE IS FULL", resume.getUuid());
        }
    }

    @Override
    protected Resume getImpl(Integer index) {
        return storage[index];
    }

    @Override
    protected void updateImpl(Integer index, Resume resume) {
        storage[index] = resume;
    }

    @Override
    protected void deleteImpl(Integer index) {
        specificDeleteImplementation(index);
        storage[size - 1] = null;
        size--;
    }

    @Override
    protected Boolean checkIndex(Integer index) {
        return (index >= 0);
    }
}
