package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractArrayStorage extends AbstractStorage<Integer> {
    protected static final int STORAGE_LIMIT = 10000;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    protected abstract void specificSaveImplementation(Resume resume, Integer index);

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
    protected List<Resume> getAll() {
        return Arrays.asList(Arrays.copyOfRange(storage, 0, size));
    }

    @Override
    protected void saveImpl(Integer searchKey, Resume resume) {
        if (size < STORAGE_LIMIT) {
            specificSaveImplementation(resume, searchKey);
            size++;
        } else {
            throw new StorageException("FAILURE!!! THE STORAGE IS FULL", resume.getUuid());
        }
    }

    @Override
    protected Resume getImpl(Integer searchKey) {
        return storage[searchKey];
    }

    @Override
    protected void updateImpl(Integer searchKey, Resume resume) {
        storage[searchKey] = resume;
    }

    @Override
    protected void deleteImpl(Integer searchKey) {
        specificDeleteImplementation(searchKey);
        storage[size - 1] = null;
        size--;
    }

    @Override
    protected Boolean isSearchKeyValid(Integer searchKey) {
        return (searchKey >= 0);
    }
}
