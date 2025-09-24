package org.eternity.exam;

import org.springframework.stereotype.Component;

@Component
public class FileWriter implements Writer{

    protected FileWriter() {}

    @Override
    public void write(String serialized) throws Exception {
        try (java.io.FileWriter writer = new java.io.FileWriter("lecture_data.txt")) {
            writer.write(serialized);
        }
    }

    @Override
    public boolean supports(StorageType storageType) {
        return StorageType.FILE.equals(storageType);
    }
}
