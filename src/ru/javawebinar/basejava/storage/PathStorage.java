package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;
import ru.javawebinar.basejava.util.Serializator;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PathStorage extends AbstractStorage<Path> {
    private Path directory;
    private Serializator serializator;

    protected PathStorage(String dir, Serializator serializator) {
        Objects.requireNonNull(dir, "directory must not be null");
        this.serializator = serializator;
        directory = Paths.get(dir);
        if (!Files.isDirectory(directory) || !Files.isWritable(directory)) {
            throw new IllegalArgumentException(dir + " is not directory or is not writable");
        }
    }

    protected void saveImpl(Path path, Resume resume) {
        try {
            Files.createFile(path);
        } catch (IOException e) {
            throw new StorageException("Error during file saving", resume.getUuid(), e);
        }
        updateImpl(path, resume);
    }

    @Override
    protected Resume getImpl(Path path) {
        try {
            return serializator.readImpl(new BufferedInputStream(Files.newInputStream(path)));
        } catch (IOException e) {
            throw new StorageException("Read operation error", path.toString(), e);
        }
    }

    @Override
    protected void updateImpl(Path path, Resume resume) {
        try {
            serializator.writeImpl(new BufferedOutputStream(Files.newOutputStream(path)), resume);
        } catch (IOException e) {
            throw new StorageException("Update operation error", path.toString(), e);
        }
    }

    @Override
    protected void deleteImpl(Path path) {
        try {
            Files.delete(path);
        } catch (IOException e) {
            throw new StorageException("Delete operation failed", path.getFileName().toString());
        }
    }

    @Override
    protected Path getSearchKey(String uuid) {
        return directory.resolve(uuid);
    }

    @Override
    protected Boolean isSearchKeyValid(Path path) {
        return Files.exists(path);
    }

    @Override
    protected List<Resume> getAll() {
        return getFilesList().map(this::getImpl).collect(Collectors.toList());
    }

    @Override
    public int size() {
        return (int) getFilesList().count();
    }

    private Stream<Path> getFilesList() {
        try {
            return Files.list(directory);
        } catch (IOException e) {
            throw new StorageException("Directory reading error", e.getMessage());
        }
    }

    @Override
    public void clear() {
        getFilesList().forEach(this::deleteImpl);
    }


}
