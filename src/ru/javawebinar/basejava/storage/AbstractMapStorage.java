package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.*;

public abstract class AbstractMapStorage extends AbstractStorage {
    protected final Map<String, Resume> storage = new HashMap<>();

    @Override
    protected abstract Resume getImpl(Object searchKey);

    @Override
    protected abstract void deleteImpl(Object searchKey);

    @Override
    protected void saveImpl(Object searchKey, Resume resume) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected void updateImpl(Object searchKey, Resume resume) {
        storage.replace((String) searchKey, resume);
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
    public List<Resume> getAllSorted() {
        List<Resume> returnValue = new ArrayList<>(storage.values());
        Collections.sort(returnValue);
        return returnValue;
    }

    @Override
    protected Object getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected Boolean isSearchKeyValid(Object searchKey) {
        return (storage.containsKey(searchKey));
    }
}
