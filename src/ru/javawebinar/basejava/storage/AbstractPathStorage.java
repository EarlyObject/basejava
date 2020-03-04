package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractPathStorage extends AbstractStorage<Path> {
    private Path directory;

    protected AbstractPathStorage(String dir) {
        directory = Paths.get(dir);
        Objects.requireNonNull(directory, "directory must not be null");
        if (!Files.isDirectory(directory) || !Files.isWritable(directory)) {
            throw new IllegalArgumentException(dir + " is not directory or is not writable");
        }
    }

    protected void saveImpl(Path path, Resume resume) {
        File file = path.toFile();
        updateImpl(file.toPath(), resume);
    }

    protected abstract void doWrite(Resume resume, OutputStream outputStream) throws IOException;

    @Override
    protected Resume getImpl(Path path) {
        try {
            return doRead(new BufferedInputStream(new FileInputStream(path.toString())));
        } catch (IOException e) {
            throw new StorageException("Read operation error", path.toString(), e);
        }
    }

    protected abstract Resume doRead(InputStream inputStream) throws IOException;

    @Override
    protected void updateImpl(Path path, Resume resume) {
        try {
            doWrite(resume, new BufferedOutputStream(new FileOutputStream(path.toString())));
        } catch (IOException e) {
            throw new StorageException("Update operation error", path.toString(), e);
        }
    }

    @Override
    protected void deleteImpl(Path path) {
        try {
            if (!Files.deleteIfExists(path)) {
                throw new StorageException("Delete operation failed", path.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Path getSearchKey(String uuid) {
        return new File(directory.toString(), uuid).toPath();
    }

    @Override
    protected Boolean isSearchKeyValid(Path path) {
        return Files.exists(path);
    }

    @Override
    protected List<Resume> getAll() {
        List<Resume> returnValue = new ArrayList<>();
        File[] files = directory.toFile().listFiles();
        if (files == null) {
            throw new StorageException("Directory is null", null);
        }
        for (File file : files) {
            returnValue.add(getImpl(file.toPath()));
        }
        return returnValue;
    }

    @Override
    public int size() {
        String[] list = directory.toFile().list();
        if (list == null) {
            throw new StorageException("Directory is null", null);
        }
        return list.length;
    }

    @Override
    public void clear() {
        try {
            Files.list(directory).forEach(this::deleteImpl);
        } catch (IOException e) {
            throw new StorageException("Delete error", null);
        }
    }
}
