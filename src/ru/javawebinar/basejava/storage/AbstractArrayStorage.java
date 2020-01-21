package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public abstract void specificSaveImplementation(Resume resume, int index);

    public abstract void specificDeleteImplementation(int index);

    protected abstract int getIndex(String uuid);

    public void save(Resume resume) {
        if (size < STORAGE_LIMIT) {
            int index = getIndex(resume.getUuid());
            if (index < 0) {
                specificSaveImplementation(resume, index);
                size++;
            } else {
                System.out.println("RESUME " + resume.getUuid() + " ALREADY EXISTS");
            }
        } else {
            System.out.println("FAILURE!!! THE STORAGE IS FULL");
        }
    }

    @Override
    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            return storage[index];
        }
        System.out.println("RESUME " + uuid + " NOT FOUND");
        return null;
    }

    @Override
    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index >= 0) {
            storage[index] = resume;
        } else {
            System.out.println("RESUME " + resume.getUuid() + " NOT FOUND");
        }
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            specificDeleteImplementation(index);
            size--;
        } else {
            System.out.println("RESUME " + uuid + " NOT FOUND");
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }
}
