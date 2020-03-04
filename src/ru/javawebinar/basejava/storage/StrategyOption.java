package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

public class StrategyOption {
    Storage storage;

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public void save(Resume resume) {
        storage.save(resume);
    }

    public Resume get(String uuid) {
        return storage.get(uuid);
    }

}
