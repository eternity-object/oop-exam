package org.eternity.exam.writer;

import java.io.IOException;

public interface Writer {
    void save(String serialized) throws IOException;
}
