package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractStorage implements Storage {

    /*protected  Integer getIndex(String uuid) {

            return uuid.hashCode();

    }
*/
    protected abstract Integer getIndex(String uuid);

    protected abstract Boolean checkIndex(Integer index);

    protected abstract void saveImpl(Resume resume, Integer index);

    protected abstract Resume getImpl(Integer index, String uuid);

    protected abstract void updateImpl(Integer index, Resume resume);

    protected abstract void deleteImpl(Integer index, String uuid);

    @Override
    public void save(Resume resume) {
        String uuid = resume.getUuid();
        saveImpl(resume, getIndexOrExist(uuid));
    }

    @Override
    public Resume get(String uuid) {
        return getImpl(getIndexOrNotExist(uuid), uuid);
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

    private Integer getIndexOrNotExist(String uuid) {
        Integer index = getIndex(uuid);
        if (checkIndex(index)) {
            return index;
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    private Integer getIndexOrExist(String uuid) {
        Integer index = getIndex(uuid);
        if (checkIndex(index)) {
            throw new ExistStorageException(uuid);
        } else {
            return index;
        }
    }
}
