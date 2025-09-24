package org.eternity.exam.save;

import java.io.FileWriter;
import org.eternity.exam.LectureReporter.StorageType;
import org.springframework.stereotype.Component;

@Component
public class SaveToToFile implements SaveToStorage {

    @Override
    public boolean isSupport(StorageType storageType) {
        return storageType.equals(StorageType.FILE);
    }

    @Override
    public void save(String serialized) {

        try (FileWriter writer = new FileWriter("lecture_data.txt")) {
            writer.write(serialized);
        }catch (Exception e){}
    }
}
