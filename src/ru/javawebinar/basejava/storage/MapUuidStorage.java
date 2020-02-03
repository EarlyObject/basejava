package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.*;

public class MapUuidStorage extends AbstractMapStorage {

    @Override
    protected Resume getImpl(Object searchKey) {
        return storage.get((String) searchKey);
    }

    @Override
    protected void deleteImpl(Object searchKey) {
        storage.remove((String) searchKey);
    }

    @Override
    protected Boolean isSearchKeyValid(Object searchKey) {
        return (storage.containsKey((String) searchKey));
    }
}
