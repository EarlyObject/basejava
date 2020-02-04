package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapResumeStorage extends AbstractStorage {
    protected final Map<String, Resume> storage = new HashMap<>();

    @Override
    protected void saveImpl(Object searchKey, Resume resume) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected Resume getImpl(Object searchKey) {
        return (Resume) searchKey;
    }

    @Override
    protected void updateImpl(Object searchKey, Resume resume) {
        storage.replace(((Resume) searchKey).getUuid(), resume);
    }

    @Override
    protected void deleteImpl(Object searchKey) {
        storage.remove(((Resume) searchKey).getUuid());
    }

    @Override
    protected Object getSearchKey(String uuid) {
        Resume returnValue = (Resume) storage.get(uuid);
        return returnValue;
    }

    @Override
    protected Boolean isSearchKeyValid(Object searchKey) {
        return (searchKey != null);
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
        sort(returnValue);
        return returnValue;
    }
}
