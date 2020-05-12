package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.util.ObjectStreamSerializator;

public class PathStorageTest extends AbstractStorageTest {

    public PathStorageTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new ObjectStreamSerializator()));
    }
}