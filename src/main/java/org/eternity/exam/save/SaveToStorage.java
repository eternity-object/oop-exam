package org.eternity.exam.save;

import org.eternity.exam.LectureReporter.StorageType;

public interface SaveToStorage {

    boolean isSupport(StorageType storageType);
    void save(String serialized);
}
