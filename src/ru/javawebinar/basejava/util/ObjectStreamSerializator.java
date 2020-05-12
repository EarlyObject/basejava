package ru.javawebinar.basejava.util;

import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.io.*;

public class ObjectStreamSerializator implements Serializator {

    @Override
    public void writeImpl(OutputStream outputStream, Resume resume) throws IOException {
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {
            objectOutputStream.writeObject(resume);
        } catch (IOException e) {
            throw new StorageException("Error during writing", resume.getUuid(), e);
        }
    }

    @Override
    public Resume readImpl(InputStream inputStream) throws IOException {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
            return (Resume)objectInputStream.readObject();
        } catch (ClassNotFoundException e) {
            throw new StorageException("Error during reading", null, e);
        }
    }
}
