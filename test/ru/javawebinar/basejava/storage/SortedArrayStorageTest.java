package ru.javawebinar.basejava.storage;

import org.junit.Assert;
import org.junit.Test;
import ru.javawebinar.basejava.model.Resume;

public class SortedArrayStorageTest extends AbstractArrayStorageTest {
    static SortedArrayStorage sortedArrayStorage = new SortedArrayStorage();

    public SortedArrayStorageTest() {
        super(sortedArrayStorage);
    }

    @Test
    public void specificSaveImplementation() {
        sortedArrayStorage.delete("uuid3");
        sortedArrayStorage.save(new Resume("uuid4"));
        sortedArrayStorage.save(new Resume("uuid3"));
        Assert.assertEquals(2, sortedArrayStorage.getIndex("uuid3"));
    }

    @Test
    public void specificDeleteImplementation() {
        sortedArrayStorage.delete("uuid1");
        Assert.assertEquals(1, sortedArrayStorage.getIndex("uuid3"));
    }

    @Test
    public void testGetIndex() {
        Assert.assertEquals(1, sortedArrayStorage.getIndex("uuid2"));
    }
}