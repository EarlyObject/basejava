package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Comparator;
import java.util.List;

public abstract class AbstractStorage implements Storage {
    private static final ResumeComparator RESUME_COMPARATOR = new ResumeComparator();

    protected abstract void saveImpl(Object searchKey, Resume resume);

    protected abstract Resume getImpl(Object searchKey);

    protected abstract void updateImpl(Object searchKey, Resume resume);

    protected abstract void deleteImpl(Object searchKey);

    protected abstract Object getSearchKey(String uuid);

    protected abstract Boolean isSearchKeyValid(Object searchKey);

    public abstract List<Resume> getAll();


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

    private static class ResumeComparator implements Comparator<Resume> {
        @Override
        public int compare(Resume o1, Resume o2) {
            if (!o1.equals(o2)) {
                return o1.getFullName().compareTo(o2.getFullName());

            } else {
                return o1.getUuid().compareTo(o2.getUuid());
            }
        }
    }
}
