package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10000;
    protected int size = 0;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];

    protected abstract void specificSaveImplementation(Resume resume, int index);

    protected abstract void specificDeleteImplementation(int index);


    public void save(Resume resume) {
        if (size < STORAGE_LIMIT) {
            Integer index = getIndex(resume);
            if (index < 0) {
                specificSaveImplementation(resume, index);
                size++;
            } else {
                throw new ExistStorageException(resume.getUuid());
            }
        } else {
            throw new StorageException("FAILURE!!! THE STORAGE IS FULL", resume.getUuid());
        }
    }

    @Override
    public Resume get(String uuid) {
        Integer index = getIndex(uuid);
        if (index >= 0) {
            return storage[index];
        }
        throw new NotExistStorageException(uuid);
    }

    @Override
    protected boolean checkAndUpdate(Resume resume, Integer index) {
        if (index >= 0) {
            storage[index] = resume;
            return true;
        }
        return false;
    }

    @Override
    protected boolean checkAndDelete(Integer index) {
        if (index >= 0) {
            specificDeleteImplementation(index);
            storage[size - 1] = null;
            size--;
            return true;
        }
        return false;
    }

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
}
