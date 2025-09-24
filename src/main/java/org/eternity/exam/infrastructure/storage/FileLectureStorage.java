package org.eternity.exam.infrastructure.storage;

import org.springframework.stereotype.Component;

import java.io.FileWriter;

@Component
public class FileLectureStorage implements LectureStorage {
    private final String fileName;

    public FileLectureStorage() {
        this("lecture_data.txt");
    }

    public FileLectureStorage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void store(String data) throws Exception {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(data);
        }
    }
}