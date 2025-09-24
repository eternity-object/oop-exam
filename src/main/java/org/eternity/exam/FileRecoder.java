package org.eternity.exam;

import java.io.FileWriter;
import java.io.IOException;

public class FileRecoder extends Recoder {

    public FileRecoder(Converter converter) {
        super(converter);
    }

    @Override
    public void save(String serialized) {
        try (FileWriter writer = new FileWriter("lecture_data.txt")) {
            writer.write(serialized);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
