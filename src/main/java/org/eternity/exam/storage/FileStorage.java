package org.eternity.exam.storage;

import org.eternity.exam.type.StorageType;

import java.io.FileWriter;

public class FileStorage implements LectureStorage{

    @Override
    public void store(String serialized) throws Exception {
        try (FileWriter writer = new FileWriter("lecture_data.txt")) {
            writer.write(serialized);
        }
    }

    @Override
    public boolean isSatisfied(StorageType storageType) {
        return storageType == StorageType.FILE;
    }
}
