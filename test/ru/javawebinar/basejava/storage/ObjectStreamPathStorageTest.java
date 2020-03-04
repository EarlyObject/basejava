package ru.javawebinar.basejava.storage;

import org.junit.Assert;
import org.junit.Test;
import ru.javawebinar.basejava.model.Resume;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ObjectStreamPathStorageTest extends AbstractStorageTest {
    Resume R1 = new Resume("uuid100", "Mister A");

    public ObjectStreamPathStorageTest() {
        super(new ObjectStreamPathStorage(STORAGE_DIR.getPath()));
    }

    StrategyOption option = new StrategyOption();
    File file = new File("storage");
    ObjectStreamPathStorage objectStreamPathStorage = new ObjectStreamPathStorage(file.getPath());

    @Test
    public void doWrite() {
        try {
            objectStreamPathStorage.doWrite(R1, new FileOutputStream("storage/uuid100"));
            option.setStorage(objectStreamPathStorage);
            Assert.assertEquals(R1, option.get("uuid100"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void doRead() {
        try {
            objectStreamPathStorage.doWrite(R1, new FileOutputStream("storage/uuid100"));
            Resume test = objectStreamPathStorage.doRead(new FileInputStream("storage/uuid100"));
            Assert.assertEquals(R1, test);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
