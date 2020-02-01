package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractStorage implements Storage {

    protected abstract Object getIndex(String uuid);

    protected abstract Boolean checkIndex(Object index);

    protected abstract void saveImpl(Resume resume, Object index);

    protected abstract Resume getImpl(Object index);

    protected abstract void updateImpl(Object index, Resume resume);

    protected abstract void deleteImpl(Object index, String uuid);

    @Override
    public void save(Resume resume) {
        String uuid = resume.getUuid();
        saveImpl(resume, getIndexOrExist(uuid));
    }

    @Override
    public Resume get(String uuid) {
        return getImpl(getIndexOrNotExist(uuid));
    }

    @Override
    public void update(Resume resume) {
        String uuid = resume.getUuid();
        updateImpl(getIndexOrNotExist(uuid), resume);
    }

    @Override
    public void delete(String uuid) {
        deleteImpl(getIndexOrNotExist(uuid), uuid);
    }

    private Object getIndexOrNotExist(String uuid) {
        Object index = getIndex(uuid);
        if (checkIndex(index)) {
            return index;
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    private Object getIndexOrExist(String uuid) {
        Object index = getIndex(uuid);
        if (checkIndex(index)) {
            throw new ExistStorageException(uuid);
        } else {
            return index;
        }
    }
}
