package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private final Resume[] storage = new Resume[10000];
    private int size = 0;

    public void save(Resume resume) {
        if (size < storage.length) {
            int index = getIndex(resume.getUuid());
            if (index < 0) {
                storage[size] = resume;
                size++;
            } else {
                System.out.println("RESUME " + resume.getUuid() + " ALREADY EXISTS");
            }
        } else {
            System.out.println("FAILURE!!! THE STORAGE IS FULL");
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            return storage[index];
        }
        System.out.println("RESUME " + uuid + " NOT FOUND");
        return null;
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index >= 0) {
            storage[index] = resume;
        } else {
            System.out.println("RESUME " + resume.getUuid() + " NOT FOUND");
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println("RESUME " + uuid + " NOT FOUND");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        Resume[] returnValue = new Resume[size];
        System.arraycopy(storage, 0, returnValue, 0, returnValue.length);
        return returnValue;
    }

    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}
