
import java.util.Arrays;


/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < storage.length; i++) {

            if (storage[i] == null) {
                break;
            } else {
                storage[i] = null;
            }
        }
    }

    void save(Resume r) {

        if (this.size() < storage.length) {
            for (int i = 0; i < storage.length; i++) {
                if (storage[i] == null) {
                    storage[i] = r;
                    break;
                }
            }
        } else {
            Resume[] copiedArray = Arrays.copyOf(storage, storage.length + 1);
            copiedArray[copiedArray.length -1] = r;
            this.storage = copiedArray;
        }
    }

    Resume get(String uuid) {
         Resume NOT_FOUND = new Resume();
         NOT_FOUND.uuid = "NOT_FOUND";

        for (Resume resume : storage) {
            if (resume != null) {
                if (resume.uuid.equals(uuid)) {
                    return resume;
                }
            }
        }
        return NOT_FOUND;
    }

    void delete(String uuid) {

        for (int i = 0; i < this.size(); i++) {
            if (this.storage[i].uuid.equals(uuid)) {
                for (int j = i; j < this.size(); j++) {
                    if (j == this.size() - 1) {
                        storage[j] = null;
                    } else {
                        storage[j] = storage[j + 1];
                    }
                }
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {

        Resume[] returnValue = new Resume[this.size()];
        if (returnValue.length >= 0) System.arraycopy(storage, 0, returnValue, 0, returnValue.length);
        return returnValue;
    }

     int size() {

        int elements = 0;
         for (Resume resume : storage) {
             if (resume != null) {
                 elements++;
             }
         }
        return elements;
    }
}
