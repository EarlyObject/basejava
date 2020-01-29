package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void specificSaveImplementation(Resume resume, int index) {
        int indexToSave = -index - 1;

        if (indexToSave != STORAGE_LIMIT - 1) {
            System.arraycopy(storage, indexToSave, storage, indexToSave + 1, size - indexToSave);
        }
        storage[indexToSave] = resume;
    }

    @Override
    protected void specificDeleteImplementation(int index) {
        if (index != size - 1) {
            System.arraycopy(storage, index + 1, storage, index, size - index - 1);
        }
    }

    @Override
    protected Integer getIndex(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
