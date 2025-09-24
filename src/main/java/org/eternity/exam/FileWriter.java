package org.eternity.exam;
public class FileWriter implements Writer{

    public FileWriter() {}

    @Override
    public void write(String serialized) throws Exception {
        try (java.io.FileWriter writer = new java.io.FileWriter("lecture_data.txt")) {
            writer.write(serialized);
        }
    }
}
