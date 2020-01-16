package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume resume) {
        if (size >= storage.length) {
            Resume[] temporaryStorage = new Resume[size + 1];
            System.arraycopy(storage, 0, temporaryStorage, 0, storage.length);
            storage = temporaryStorage;
        }

        int index = indexInStorage(resume.getUuid());
        if (index < 0) {
            storage[size] = resume;
            size++;
        }
    }

    public Resume get(String uuid) {
        int index = indexInStorage(uuid);
        if (index >= 0) {
            return storage[index];
        }
        return null;
    }

    public void update(Resume resume) {
        int index = indexInStorage(resume.getUuid());
        if (index >= 0) {
            storage[index] = resume;
        }
    }

    public void delete(String uuid) {
        int index = indexInStorage(uuid);
        if (index >= 0) {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

    public int indexInStorage(String uuid) {
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                if (uuid.equals(storage[i].getUuid())) {
                    return i;
                }
            }
        }
        System.out.println("Resume not found in storage");
        return -1;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        Resume[] returnValue = new Resume[size];
        Arrays.asList(storage).subList(0, size).toArray(returnValue);
        return returnValue;
    }

    public int size() {
        return size;
    }
}
