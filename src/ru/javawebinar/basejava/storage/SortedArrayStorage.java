package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void save(Resume resume) {
        if (size < STORAGE_LIMIT) {
            int index = getIndex(resume.getUuid());
            int indexToSave = size;
            if (index < 0) {
                for (int i = size - 1; (i >= 0 && resume.getUuid().compareTo(storage[i].getUuid()) < 1); i--) {
                    indexToSave = i;
                    storage[i + 1] = storage[i];
                }
                storage[indexToSave] = resume;
                size++;
            } else {
                System.out.println("RESUME " + resume.getUuid() + " ALREADY EXISTS");
            }
        } else {
            System.out.println("FAILURE!!! THE STORAGE IS FULL");
        }
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            if (size - index >= 0) System.arraycopy(storage, index + 1, storage, index, size - index);
            size--;
        } else {
            System.out.println("RESUME " + uuid + " NOT FOUND");
        }
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
