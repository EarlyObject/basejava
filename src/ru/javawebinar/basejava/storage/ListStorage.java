package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    protected final List<Resume> storage = new ArrayList<>();

    @Override
    protected void saveImpl(Resume resume, Object index) {
        storage.add(resume);
    }

    @Override
    protected Resume getImpl(Object index) {
        return storage.get((Integer) index);
    }

    @Override
    protected void updateImpl(Object index, Resume resume) {
        storage.set((Integer) index, resume);
    }

    @Override
    protected void deleteImpl(Object index, String uuid) {
        storage.remove(((Integer) index).intValue());
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
    protected Integer getIndex(String uuid) {
        int storageSize = storage.size();
        for (int i = 0; i < storageSize; i++) {
            if (uuid.equals(storage.get(i).getUuid())) {
                return i;
            }
        }
        return null;
    }

    @Override
    protected Boolean checkIndex(Object index) {
        return (index != null);
    }
}
