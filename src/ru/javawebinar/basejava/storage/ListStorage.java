package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage<Integer> {
    protected final List<Resume> storage = new ArrayList<>();

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    protected void saveImpl(Integer searchKey, Resume resume) {
        storage.add(resume);
    }

    @Override
    protected Resume getImpl(Integer searchKey) {
        return storage.get(searchKey);
    }

    @Override
    protected void updateImpl(Integer searchKey, Resume resume) {
        storage.set(searchKey, resume);
    }

    @Override
    protected void deleteImpl(Integer searchKey) {
        storage.remove(searchKey.intValue());
    }

    @Override
    protected List<Resume> getAll() {
        return new ArrayList<>(storage);
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
    protected Boolean isSearchKeyValid(Integer searchKey) {
        return (searchKey != null);
    }
}
