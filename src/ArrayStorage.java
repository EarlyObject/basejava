/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size = 0;

    void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
    }

    void save(Resume resume) {
        for (int i = 0; i <= size; i++) {
            if (storage[i] == null) {
                storage[i] = resume;
                size++;
                break;
            }
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            try {
                if (storage[i].uuid.equals(uuid)) {
                    return storage[i];
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                if (i == size - 1) {
                    storage[i] = null;
                } else {
                    storage[i] = storage[size - 1];
                    storage[size - 1] = null;
                }
                size--;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] returnValue = new Resume[size];
        System.arraycopy(storage, 0, returnValue, 0, returnValue.length);
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
