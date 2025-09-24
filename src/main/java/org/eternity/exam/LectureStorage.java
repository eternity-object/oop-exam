package org.eternity.exam;

import java.io.IOException;

public interface LectureStorage {
    void write(String content) throws IOException;
}
