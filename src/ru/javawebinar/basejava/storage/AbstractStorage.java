package ru.javawebinar.basejava.storage;

public abstract class AbstractStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;
    protected int size = 0;

    protected abstract Integer getIndex(String uuid);

    @Override
    public abstract int size();

    @Override
    public void clear() {

    }
}
