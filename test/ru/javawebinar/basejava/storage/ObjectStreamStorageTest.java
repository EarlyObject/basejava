package ru.javawebinar.basejava.storage;

import org.junit.Assert;
import org.junit.Test;
import ru.javawebinar.basejava.model.Resume;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ObjectStreamStorageTest extends AbstractStorageTest {

    public ObjectStreamStorageTest() {
        super(new ObjectStreamStorage(STORAGE_DIR));
    }

    Resume R1 = new Resume("uuid100", "Mister A");

    StrategyOption option = new StrategyOption();
    File file = new File("storage");
    ObjectStreamStorage objectStreamStorage = new ObjectStreamStorage(file);

    @Test
    public void doWrite() {
        try {
            objectStreamStorage.doWrite(R1, new FileOutputStream("storage/uuid100"));
            option.setStorage(objectStreamStorage);
            Assert.assertEquals(R1, option.get("uuid100"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void doRead() {
        try {
            objectStreamStorage.doWrite(R1, new FileOutputStream("storage/uuid100"));
            Resume test = objectStreamStorage.doRead(new FileInputStream("storage/uuid100"));
            Assert.assertEquals(R1, test);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
