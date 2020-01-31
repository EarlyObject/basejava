package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    protected final List<Resume> storage = new ArrayList<>();

    @Override
    protected void saveImpl(Resume resume, Integer index) {
        storage.add(resume);
    }

    @Override
    protected Resume getImpl(Integer index, String uuid) {
        return storage.get(index);
    }

    @Override
    protected void updateImpl(Integer index, Resume resume) {
        storage.set(index, resume);
    }

    @Override
    protected void deleteImpl(Integer index, String uuid) {
        storage.remove(index.intValue());
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
    protected Boolean checkIndex(Integer index) {
        return (index != null);
    }
}
