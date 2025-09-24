package org.eternity.exam.writer;

import java.io.IOException;

public class FileWriter implements Writer {
    @Override
    public void save(String serialized) throws IOException {
        try (java.io.FileWriter writer = new java.io.FileWriter("lecture_data.txt")) {
            writer.write(serialized);
        }
    }
}
