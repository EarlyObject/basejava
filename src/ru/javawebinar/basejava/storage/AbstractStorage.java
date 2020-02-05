package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractStorage<SK> implements Storage {
    private static final Logger LOG = Logger.getLogger(AbstractStorage.class.getName());

    private static final Comparator<Resume> RESUME_COMPARATOR = Comparator.comparing(Resume::getFullName).thenComparing(Resume::getUuid);

    protected abstract void saveImpl(SK searchKey, Resume resume);

    protected abstract Resume getImpl(SK searchKey);

    protected abstract void updateImpl(SK searchKey, Resume resume);

    protected abstract void deleteImpl(SK searchKey);

    protected abstract SK getSearchKey(String uuid);

    protected abstract Boolean isSearchKeyValid(SK searchKey);

    protected abstract List<Resume> getAll();

    @Override
    public void save(Resume resume) {
        LOG.info("Save " + resume);
        String uuid = resume.getUuid();
        saveImpl(getSearchKeyOrExistEx(uuid), resume);
    }

    @Override
    public Resume get(String uuid) {
        LOG.info("Get " + uuid);
        return getImpl(getSearchKeyOrNotExistEx(uuid));
    }

    @Override
    public void update(Resume resume) {
        LOG.info("Update " + resume);
        String uuid = resume.getUuid();
        updateImpl(getSearchKeyOrNotExistEx(uuid), resume);
    }

    @Override
    public void delete(String uuid) {
        LOG.info("Delete " + uuid);
        deleteImpl(getSearchKeyOrNotExistEx(uuid));
    }

    @Override
    public List<Resume> getAllSorted() {
        LOG.info("getAllSorted");
        List<Resume> returnValue = getAll();
        returnValue.sort(RESUME_COMPARATOR);
        return returnValue;
    }

    private SK getSearchKeyOrNotExistEx(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (isSearchKeyValid(searchKey)) {
            return searchKey;
        } else {
            LOG.warning("RESUME " + uuid + " DOES NOT EXIST");

            throw new NotExistStorageException(uuid);
        }
    }

    private SK getSearchKeyOrExistEx(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (isSearchKeyValid(searchKey)) {
            LOG.warning("RESUME " + uuid + " ALREADY EXISTS");
            throw new ExistStorageException(uuid);
        } else {
            return searchKey;
        }
    }
}
