package ru.javawebinar.basejava.storage;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MapStorageTest extends AbstractStorageTest {

    public MapStorageTest() {
        super(new MapStorage());
    }

    @Override
    @Test
    public void getAll() {
        assertEquals(3, storage.getAll().length);
    }
}