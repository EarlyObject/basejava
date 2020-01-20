package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void specificSaveImplementation(Resume resume) {
        int indexToSave = size;

        for (int i = size - 1; (i >= 0) && (resume.getUuid().compareTo(storage[i].getUuid()) < 1); i--) {
            indexToSave = i;
            System.arraycopy(storage, i, storage, i + 1, 1);
        }
        storage[indexToSave] = resume;
        size++;
    }

    @Override
    public void specificDeleteImplementation(int index) {
        if (index == size - 1) {
            storage[index] = null;
        } else {
            System.arraycopy(storage, index + 1, storage, index, size - index);
        }
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
