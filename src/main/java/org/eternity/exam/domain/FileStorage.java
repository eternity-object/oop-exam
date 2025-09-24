package org.eternity.exam.domain;

import org.springframework.stereotype.Component;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component("fileStorage")
public class FileStorage implements Storage {
    public void save(String data, String sourceName) {
        try {
            Files.writeString(Paths.get(sourceName + ".txt"), data);
            System.out.println("[FILE] 저장 완료: " + sourceName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}