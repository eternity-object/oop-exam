package org.eternity.exam.storage;

public interface LectureStorage {
    StorageType key();
    void save(String payload) throws Exception;
}
