package org.eternity.exam;

import org.springframework.jdbc.core.simple.JdbcClient;

public class WriterFactory {
    public static Writer createWriter(StorageType storageType, JdbcClient jdbcClient) {
        switch (storageType) {
            case DATABASE:
                return new DbWriter(jdbcClient);
            case FILE:
                return new FileWriter();
            default:
                throw new IllegalArgumentException();
        }
    }
}
