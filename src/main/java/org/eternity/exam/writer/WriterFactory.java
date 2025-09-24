package org.eternity.exam.writer;

import org.eternity.exam.type.StorageType;
import org.springframework.jdbc.core.simple.JdbcClient;

public class WriterFactory {

    private final JdbcClient jdbcClient;

    public WriterFactory(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public Writer getWriter(StorageType storageType) {
        switch (storageType) {
            case DATABASE -> {
                return new DatabaseWriter(jdbcClient);
            }
            case FILE -> {
                return new FileWriter();
            }
            default -> {
                return null;
            }
        }
    }
}
