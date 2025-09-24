package org.eternity.exam.storages;

import org.eternity.exam.LectureStorage;

import java.io.FileWriter;
import java.io.IOException;

public class FileLectureStorage implements LectureStorage {
    @Override
    public void write(String content) throws IOException {
        try (FileWriter writer = new FileWriter("lecture_data.txt")) {
            writer.write(content);
        }
    }
}
