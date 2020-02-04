package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractArrayStorage extends AbstractStorage {
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
    public List<Resume> getAllSorted() {
        List<Resume> returnValue = Arrays.asList(Arrays.copyOfRange(storage, 0, size));
        sort(returnValue);
        return returnValue;
    }

    @Override
    protected void saveImpl(Object searchKey, Resume resume) {
        if (size < STORAGE_LIMIT) {
            specificSaveImplementation(resume, (Integer) searchKey);
            size++;
        } else {
            throw new StorageException("FAILURE!!! THE STORAGE IS FULL", resume.getUuid());
        }
    }

    @Override
    protected Resume getImpl(Object searchKey) {
        return storage[(Integer) searchKey];
    }

    @Override
    protected void updateImpl(Object searchKey, Resume resume) {
        storage[(Integer) searchKey] = resume;
    }

    @Override
    protected void deleteImpl(Object searchKey) {
        specificDeleteImplementation((Integer) searchKey);
        storage[size - 1] = null;
        size--;
    }

    @Override
    protected Boolean isSearchKeyValid(Object searchKey) {
        return ((Integer) searchKey >= 0);
    }
}
