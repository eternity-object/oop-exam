package org.eternity.exam;

import java.io.FileWriter;

public class FileLectureStorage implements LectureStorage {
    private final String filePath;

    public FileLectureStorage(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void store(String data) throws Exception {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(data);
        }
    }
}
