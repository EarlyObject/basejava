package ru.javawebinar.basejava.storage;

import org.junit.Assert;
import org.junit.Test;
import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;
import java.util.Collections;

public class ArrayStorageTest extends AbstractArrayStorageTest {
    static ArrayStorage arrayStorage = new ArrayStorage();

    public ArrayStorageTest() {
        super(arrayStorage);
    }


    @Test
    public void specificSaveImplementation() {
        arrayStorage.save(new Resume());
        Assert.assertEquals(4, arrayStorage.size());
    }

    @Test
    public void specificDeleteImplementation() {
        arrayStorage.delete("uuid1");
        Assert.assertEquals(0, arrayStorage.getIndex("uuid3"));
    }

    @Test
    public void testGetIndex() {
        Assert.assertEquals(1, arrayStorage.getIndex("uuid2"));
    }
}