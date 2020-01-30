package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractStorage implements Storage {
    protected abstract boolean checkAndUpdate(Resume resume, Integer index);

    protected abstract boolean checkAndDelete(Integer index);

    protected abstract Integer getIndex(String uuid);

    @Override
    public void update(Resume resume) {
        Integer index = getIndex(resume);
        if (!checkAndUpdate(resume, index)) {
            throw new NotExistStorageException(resume.getUuid());
        }
    }

    @Override
    public void delete(String uuid) {
        Integer index = getIndex(uuid);
        if (!checkAndDelete(index)) {
            throw new NotExistStorageException(uuid);
        }
    }

    protected Integer getIndex(Resume resume) {
        return getIndex(resume.getUuid());
    }
}
