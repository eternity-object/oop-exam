package org.eternity.exam.writer;

import java.io.IOException;

public class FileWriter implements Writer {
    @Override
    public void write(String str) {
        try (java.io.FileWriter writer = new java.io.FileWriter("lecture_data.txt")) {
            writer.write(str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
