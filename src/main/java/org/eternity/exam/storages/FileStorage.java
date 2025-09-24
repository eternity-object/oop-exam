package org.eternity.exam.storages;

import org.eternity.exam.Storage;

import java.io.FileWriter;
import java.io.IOException;

public class FileStorage implements Storage {
    @Override
    public void write(String content) throws IOException {
        try (FileWriter writer = new FileWriter("lecture_data.txt")) {
            writer.write(content);
        }
    }
}
