package org.eternity.exam.storage;

import org.springframework.jdbc.core.simple.JdbcClient;

import java.io.FileWriter;
import java.io.IOException;

public class FileStorage implements LectureStorage{

    @Override
    public void save(String serialized) throws IOException {
        try (FileWriter writer = new FileWriter("lecture_data.txt")) {
            writer.write(serialized);
        }
    }
}
