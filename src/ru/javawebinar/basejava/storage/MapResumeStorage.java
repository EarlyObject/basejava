package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

public class MapResumeStorage extends MapUuidStorage {

    @Override
    protected Resume getImpl(Object searchKey) {
        return (Resume) searchKey;
    }

    @Override
    protected void updateImpl(Object searchKey, Resume resume) {
        storage.replace(((Resume)searchKey).getUuid(), resume);
    }

    @Override
    protected void deleteImpl(Object searchKey) {
        storage.remove(((Resume) searchKey).getUuid());
    }

    @Override
    protected Object getSearchKey(String uuid) {
        Resume returnValue = (Resume)storage.get(uuid);
        return returnValue;
    }

    @Override
    protected Boolean isSearchKeyValid(Object searchKey) {
        return (storage.containsKey(((Resume)searchKey).getUuid()));
    }
}
