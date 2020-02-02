package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractStorage implements Storage {

    protected abstract void saveImpl(Object searchKey, Resume resume);

    protected abstract Resume getImpl(Object searchKey);

    protected abstract void updateImpl(Object searchKey, Resume resume);

    protected abstract void deleteImpl(Object searchKey);

    protected abstract Object getSearchKey(String uuid);

    protected abstract Boolean isSearchKeyValid(Object searchKey);

    @Override
    public void save(Resume resume) {
        String uuid = resume.getUuid();
        saveImpl(getSearchKeyOrExistEx(uuid), resume);
    }

    @Override
    public Resume get(String uuid) {
        return getImpl(getSearchKeyOrNotExistEx(uuid));
    }

    @Override
    public void update(Resume resume) {
        String uuid = resume.getUuid();
        updateImpl(getSearchKeyOrNotExistEx(uuid), resume);
    }

    @Override
    public void delete(String uuid) {
        deleteImpl(getSearchKeyOrNotExistEx(uuid));
    }

    private Object getSearchKeyOrNotExistEx(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (isSearchKeyValid(searchKey)) {
            return searchKey;
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    private Object getSearchKeyOrExistEx(String uuid) {
        Object index = getSearchKey(uuid);
        if (isSearchKeyValid(index)) {
            throw new ExistStorageException(uuid);
        } else {
            return index;
        }
    }
}
