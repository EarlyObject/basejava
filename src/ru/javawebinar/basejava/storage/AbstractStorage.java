package ru.javawebinar.basejava.storage;

public abstract class AbstractStorage implements Storage {

    protected abstract Integer getIndex(String uuid);

    @Override
    public abstract int size();

    @Override
    public void clear() {

    }
}
