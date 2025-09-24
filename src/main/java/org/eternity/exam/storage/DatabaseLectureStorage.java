package org.eternity.exam.storage;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLectureStorage implements LectureStorage {
    private final JdbcClient jdbcClient;

    public DatabaseLectureStorage(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override public StorageType key() { return StorageType.DB; }

    @Override
    public void save(String payload) {
        jdbcClient.sql("INSERT INTO LECTURE(SERIALIZED_DATA) VALUES(?)")
                .param(1, payload)
                .update();
    }
}
