package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;
import ru.javawebinar.basejava.util.Serializator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileStorage extends AbstractStorage<File> {
    private File directory;
    private Serializator serializator;

    protected FileStorage(File directory, Serializator serializator) {
        Objects.requireNonNull(directory, "directory must not be null");
        this.serializator = serializator;
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not directory");
        }
        if (!directory.canRead() || !directory.canWrite()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not readable/writable");
        }
        this.directory = directory;
    }

    protected void saveImpl(File file, Resume resume) {
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new StorageException("Create operation error", file.getName(), e);
        }
        updateImpl(file, resume);
    }


    @Override
    protected Resume getImpl(File file) {
        try {
            Resume resume = serializator.readImpl(new BufferedInputStream(new FileInputStream(file)));
            return resume;
        } catch (IOException e) {
            throw new StorageException("Read operation error" + e.getMessage() , file.getName(), e);
        }
    }

    @Override
    protected void updateImpl(File file, Resume resume) {
        try {
            serializator.writeImpl(new BufferedOutputStream(new FileOutputStream(file)), resume);
        } catch (IOException e) {
            throw new StorageException("Update operation error", resume.getUuid(), e);
        }
    }

    @Override
    protected void deleteImpl(File file) {
        if (!file.delete()) {
            throw new StorageException("Delete operation failed", file.getName());
        }
    }

    @Override
    protected File getSearchKey(String uuid) {
        return new File(directory, uuid);
    }

    @Override
    protected Boolean isSearchKeyValid(File file) {
        return file.exists();
    }

    @Override
    protected List<Resume> getAll() {
        List<Resume> returnValue = new ArrayList<>();
        File[] files = directory.listFiles();
        nullCheck(files);
        for (File file : files) {
            returnValue.add(getImpl(file));
        }
        return returnValue;
    }

    @Override
    public int size() {
        String[] list = directory.list();
        nullCheck(list);
        return list.length;
    }

    @Override
    public void clear() {
        File[] files = directory.listFiles();
        nullCheck(files);

        for (File file : files) {
            deleteImpl(file);
        }
    }

    public <T> void nullCheck(T[] files) {
        if (files == null) {
            throw new StorageException("Directory is null", null);
        }
    }
}
