package org.eternity.exam;

import java.io.FileWriter;
import org.eternity.exam.LectureReporter.StorageType;
import org.springframework.jdbc.core.simple.JdbcClient;

public abstract class AbstractReporter implements Reporter {

    private final JdbcClient jdbcClient;

    public AbstractReporter(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public void report(StorageType storageType) throws Exception {
        String converted = convert();
        save(converted, storageType);
    }

    private void save(String serialized, StorageType storageType) throws Exception {
        switch (storageType) {
            case DATABASE -> {
                jdbcClient.sql("INSERT INTO LECTURE(SERIALIZED_DATA) VALUES(?)")
                        .param(1, serialized)
                        .update();
            }
            case FILE -> {
                try (FileWriter writer = new FileWriter("lecture_data.txt")) {
                    writer.write(serialized);
                }
            }
        }
    }

    protected abstract String convert() throws Exception;
}
