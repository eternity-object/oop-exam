package org.eternity.exam.storagewriter;

import java.io.IOException;

public interface StorageWriter {
    void write(String content) throws IOException;
}
