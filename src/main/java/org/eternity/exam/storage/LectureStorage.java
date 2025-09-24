package org.eternity.exam.storage;

import org.eternity.exam.type.StorageType;

public interface LectureStorage {
    void store(String serialized) throws Exception;

    boolean isSatisfied(StorageType storageType);
}
