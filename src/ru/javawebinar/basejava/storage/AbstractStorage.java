package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Comparator;
import java.util.List;

public abstract class AbstractStorage implements Storage {
    private static final Comparator<Resume> RESUME_COMPARATOR = Comparator.comparing(Resume::getFullName).thenComparing(Resume::getUuid);

    protected abstract void saveImpl(Object searchKey, Resume resume);

    protected abstract Resume getImpl(Object searchKey);

    protected abstract void updateImpl(Object searchKey, Resume resume);

    protected abstract void deleteImpl(Object searchKey);

    protected abstract Object getSearchKey(String uuid);

    protected abstract Boolean isSearchKeyValid(Object searchKey);

    protected abstract List<Resume> getAll();

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

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> returnValue = getAll();
        returnValue.sort(RESUME_COMPARATOR);
        return returnValue;
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
        Object searchKey = getSearchKey(uuid);
        if (isSearchKeyValid(searchKey)) {
            throw new ExistStorageException(uuid);
        } else {
            return searchKey;
        }
    }
}
