package ru.javawebinar.basejava.util;

import ru.javawebinar.basejava.model.Resume;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface Serializator {

    void writeImpl(OutputStream outputStream, Resume resume) throws IOException;

    Resume readImpl(InputStream inputStream) throws IOException;

}
