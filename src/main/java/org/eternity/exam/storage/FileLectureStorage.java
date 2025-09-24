package org.eternity.exam.storage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileWriter;

@Component
public class FileLectureStorage implements LectureStorage {
    private final String filePath;

    public FileLectureStorage(@Value("${lecture.file.path:lecture_data.txt}") String filePath) {
        this.filePath = filePath;
    }

    @Override public StorageType key() { return StorageType.FILE; }

    @Override
    public void save(String payload) throws Exception {
        try (FileWriter writer = new FileWriter(filePath, false)) {
            writer.write(payload);
        }
    }
}
