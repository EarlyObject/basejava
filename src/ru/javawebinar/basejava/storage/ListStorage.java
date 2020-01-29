package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    protected final List<Resume> storage = new ArrayList<>();

    @Override
    public void save(Resume resume) {
        if (getIndex(resume) != null) {
            throw new ExistStorageException(resume.getUuid());
        } else {
            storage.add(resume);
        }
    }

    @Override
    public Resume get(String uuid) {
        if (getIndex(uuid) != null) {
            return storage.get(getIndex(uuid));
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    @Override
    public void update(Resume resume) {
        if (getIndex(resume) != null) {
            storage.set(getIndex(resume), resume);
        } else {
            throw new NotExistStorageException(resume.getUuid());
        }
    }

    @Override
    public void delete(String uuid) {
        if (getIndex(uuid) != null) {
            Resume resume = get(uuid);
            storage.remove(resume);
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public Resume[] getAll() {
        Resume[] resumes = new Resume[storage.size()];
        return storage.toArray(resumes);
    }

    protected Integer getIndex(Resume resume) {
        return getIndex(resume.getUuid());
    }

    @Override
    protected Integer getIndex(String uuid) {
        int storageSize = storage.size();
        for (int i = 0; i < storageSize; i++) {
            if (uuid.equals(storage.get(i).getUuid())) {
                return i;
            }
        }
        return null;
    }
}
