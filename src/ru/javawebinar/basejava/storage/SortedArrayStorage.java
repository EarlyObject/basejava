package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void specificSaveImplementation(Resume resume, int index) {
        int indexToSave = Math.abs(index) - 1;

        if (Math.abs(index) != STORAGE_LIMIT) {
            System.arraycopy(storage, indexToSave, storage, indexToSave + 1, size - indexToSave);
        }
        storage[indexToSave] = resume;
    }

    @Override
    public void specificDeleteImplementation(int index) {
        if (index == size - 1) {
            storage[index] = null;
        } else {
            System.arraycopy(storage, index + 1, storage, index, size - index - 1);
            storage[size - 1] = null;
        }
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
