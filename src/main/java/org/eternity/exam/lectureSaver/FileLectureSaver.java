package org.eternity.exam.lectureSaver;

import org.eternity.exam.LectureSaver;
import org.eternity.exam.StorageType;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
@Service
public class FileLectureSaver implements LectureSaver {

    private final StorageType storageType = StorageType.FILE;
    @Override
    public void save(String serialized) throws IOException {
        try (FileWriter writer = new FileWriter("lecture_data.txt")) {
            writer.write(serialized);
        }
    }

    @Override
    public boolean isType(StorageType type) {
        return type.equals(storageType);
    }
}
