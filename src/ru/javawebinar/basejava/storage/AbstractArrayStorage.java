package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];

    protected abstract void specificSaveImplementation(Resume resume, int index);

    protected abstract void specificDeleteImplementation(int index);


    public void save(Resume resume) {
        if (size < STORAGE_LIMIT) {
            int index = getIndex(resume.getUuid());
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
        int index = getIndex(uuid);
        if (index >= 0) {
            return storage[index];
        }
        throw new NotExistStorageException(uuid);
    }

    @Override
    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index >= 0) {
            storage[index] = resume;
        } else {
            throw new NotExistStorageException(resume.getUuid());
        }
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            specificDeleteImplementation(index);
            storage[size - 1] = null;
            size--;
        } else {
            throw new NotExistStorageException(uuid);
        }
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
