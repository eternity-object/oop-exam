package org.eternity.exam.storage;

import java.io.IOException;

public interface LectureStorage {
    void save(String serialized) throws IOException;
}
