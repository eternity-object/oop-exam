package org.eternity.exam;

import java.io.FileWriter;
import java.io.IOException;
import org.springframework.jdbc.core.simple.JdbcClient;

public class FileLectureStorage implements LectureStorage {
    @Override
    public void save(String serializedLecture) {
        try (FileWriter writer = new FileWriter("lecture_data.txt")) {
            writer.write(serializedLecture);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
