package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractStorage implements Storage {

    protected abstract Integer getIndex(String uuid);

    protected abstract Boolean checkIndex(Integer index);

    protected abstract void saveImpl(Resume resume, Integer index);

    protected abstract Resume getImpl(Integer index);

    protected abstract void updateImpl(Integer index, Resume resume);

    protected abstract void deleteImpl(Integer index);

    @Override
    public void save(Resume resume) {
        String uuid = resume.getUuid();
        saveImpl(resume, returnIndexOrThrowExist(uuid));
    }

    @Override
    public Resume get(String uuid) {
        return getImpl(returnIndexOrThrowNotExist(uuid));
    }

    @Override
    public void update(Resume resume) {
        String uuid = resume.getUuid();
        updateImpl(returnIndexOrThrowNotExist(uuid), resume);
    }

    @Override
    public void delete(String uuid) {
        deleteImpl(returnIndexOrThrowNotExist(uuid));
    }

    public Integer returnIndexOrThrowNotExist(String uuid) {
        Integer index = getIndex(uuid);
        if (checkIndex(index)) {
            return index;
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    public Integer returnIndexOrThrowExist(String uuid) {
        Integer index = getIndex(uuid);
        if (checkIndex(index)) {
            throw new ExistStorageException(uuid);
        } else {
            return index;
        }
    }
}
