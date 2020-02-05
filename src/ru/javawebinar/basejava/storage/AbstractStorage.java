package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Comparator;
import java.util.List;

public abstract class AbstractStorage<SK> implements Storage {
    private static final Comparator<Resume> RESUME_COMPARATOR = Comparator.comparing(Resume::getFullName).thenComparing(Resume::getUuid);

    protected abstract void saveImpl(SK searchKey, Resume resume);

    protected abstract Resume getImpl(SK searchKey);

    protected abstract void updateImpl(SK searchKey, Resume resume);

    protected abstract void deleteImpl(SK searchKey);

    protected abstract SK getSearchKey(String uuid);

    protected abstract Boolean isSearchKeyValid(SK searchKey);

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

    private SK getSearchKeyOrNotExistEx(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (isSearchKeyValid(searchKey)) {
            return searchKey;
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    private SK getSearchKeyOrExistEx(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (isSearchKeyValid(searchKey)) {
            throw new ExistStorageException(uuid);
        } else {
            return searchKey;
        }
    }
}
