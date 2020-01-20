package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

public class ArrayStorage extends AbstractArrayStorage {

    @Override
    public void save(Resume resume) {
        if (size < STORAGE_LIMIT) {
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

    @Override
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

    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}
