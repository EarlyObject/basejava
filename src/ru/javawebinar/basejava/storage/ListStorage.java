package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    protected final List<Resume> storage = new ArrayList<>();

    @Override
    protected void saveImpl(Object searchKey, Resume resume) {
        storage.add(resume);
    }

    @Override
    protected Resume getImpl(Object searchKey) {
        return storage.get((Integer) searchKey);
    }

    @Override
    protected void updateImpl(Object searchKey, Resume resume) {
        storage.set((Integer) searchKey, resume);
    }

    @Override
    protected void deleteImpl(Object searchKey) {
        storage.remove(((Integer) searchKey).intValue());
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
        return storage.toArray(resumes);
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        int storageSize = storage.size();
        for (int i = 0; i < storageSize; i++) {
            if (uuid.equals(storage.get(i).getUuid())) {
                return i;
            }
        }
        return null;
    }

    @Override
    protected Boolean isSearchKeyValid(Object searchKey) {
        return (searchKey != null);
    }
}
