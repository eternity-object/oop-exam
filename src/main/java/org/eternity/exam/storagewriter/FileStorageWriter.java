package org.eternity.exam.storagewriter;

import java.io.FileWriter;
import java.io.IOException;

public class FileStorageWriter implements StorageWriter{

    @Override
    public void write(String content) throws IOException {
        try (FileWriter writer = new FileWriter("lecture_data.txt")) {
            writer.write(content);
        }
    }
}
