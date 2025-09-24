package org.eternity.exam.storage;

import org.eternity.exam.type.StorageType;
import org.springframework.jdbc.core.simple.JdbcClient;

public class DatabaseStorage implements LectureStorage{

    private final JdbcClient jdbcClient;

    public DatabaseStorage(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public void store(String serialized) {
        jdbcClient.sql("INSERT INTO LECTURE(SERIALIZED_DATA) VALUES(?)")
            .param(1, serialized)
            .update();
    }

    @Override
    public boolean isSatisfied(StorageType storageType) {
        return storageType == StorageType.DATABASE;
    }
}
