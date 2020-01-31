package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    protected final Map<String, Resume> storage = new LinkedHashMap<>();

    @Override
    protected Integer getIndex(String uuid) {
        if (storage.containsKey(uuid)) {
            return new ArrayList<>(storage.keySet()).indexOf(uuid);
        }
        return null;
    }

    @Override
    protected Boolean checkIndex(Integer index) {
        return (index != null);
    }

    @Override
    protected void saveImpl(Resume resume, Integer index) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected Resume getImpl(Integer index, String uuid) {
        return storage.get(uuid);
    }

    @Override
    protected void updateImpl(Integer index, Resume resume) {
        storage.replace(resume.getUuid(), resume);
    }

    @Override
    protected void deleteImpl(Integer index, String uuid) {
        storage.remove(uuid);
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
    public Resume[] getAll() {
        Resume[] resumes = new Resume[storage.size()];
        return storage.values().toArray(resumes);
    }
}
