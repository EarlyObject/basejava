package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AbstractPathStorage extends FilePathContext<Path> {
    private Path directory;

    protected AbstractPathStorage(String dir) {
        super(Paths.get(dir).toFile());
    }

    @Override
    protected void saveImpl(Path path, Resume resume) {
        Path file;
        try {
            file = Files.createFile(path);
        } catch (IOException e) {
            throw new StorageException("Save operation error", path.toString(), e);
        }
        updateImpl(file, resume);
    }

    @Override
    protected Resume getImpl(Path path) {
        try {
            return objectStream.doRead(Files.newInputStream(path));
        } catch (IOException e) {
            throw new StorageException("Read operation error", path.toString(), e);
        }
    }

    @Override
    protected void updateImpl(Path path, Resume resume) {
        try {
            objectStream.doWrite(resume, Files.newOutputStream(path));
        } catch (IOException e) {
            throw new StorageException("Update operation error", path.toString(), e);
        }
    }

    @Override
    protected void deleteImpl(Path path) {
        try {
            Files.deleteIfExists(path);
        } catch (IOException e) {
            throw new StorageException("Delete operation failed", path.toString());
        }
    }

    @Override
    protected Path getSearchKey(String uid) {
        try {
            return Files.createFile(directory.resolve(uid));
        } catch (IOException e) {
            throw new StorageException("Search operation failed", uid);
        }
    }

    @Override
    protected Boolean isSearchKeyValid(Path path) {
        return Files.exists(path);
    }

    @Override
    protected Path converter(File file) {
        return file.toPath();
    }
}