package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class FilePathContext<SK> extends AbstractStorage<SK> {

    protected File directory;
    protected AbstractObjectStream objectStream;

    public FilePathContext(File directory) {
        Objects.requireNonNull(directory, "directory must not be null");
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not directory");
        }
        if (!directory.canRead() || !directory.canWrite()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not readable/writable");
        }
        this.directory = directory;
    }

    public void setObjectStream(AbstractObjectStream objectStream) {
        this.objectStream = objectStream;
    }

    protected abstract SK converter(File file);

    @Override
    protected List<Resume> getAll() {
        List<Resume> returnValue = new ArrayList<>();
        File[] files = getList();
        for (File file : files) {
            returnValue.add(getImpl(
                    converter(file)));
        }
        return returnValue;
    }

    protected File[] getList() {
        File[] files = directory.listFiles();
        if (files == null) {
            throw new StorageException("Directory is null", null);
        }
        return files;
    }

    @Override
    public int size() {
        return getList().length;
    }

    @Override
    public void clear() {
        for (File file : getList()) {
            deleteImpl(converter(file));
        }
    }
}
