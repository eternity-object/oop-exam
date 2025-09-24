package org.eternity.exam.writer;

import org.eternity.exam.LectureReporter;
import org.springframework.jdbc.core.simple.JdbcClient;

public class WriterFactory {
    private final JdbcClient jdbcClient;

    public WriterFactory(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public Writer createWriter(LectureReporter.StorageType storageType) {
        return switch (storageType) {
            case DATABASE -> new DatabaseWriter(jdbcClient);
            case FILE -> new FileWriter();
        };
    }
}
