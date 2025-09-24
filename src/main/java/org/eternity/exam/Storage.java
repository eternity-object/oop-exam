package org.eternity.exam;

import java.io.IOException;

public interface Storage {
    void write(String content) throws IOException;
}
