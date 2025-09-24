package org.eternity.exam.infrastructure.storage;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLectureStorage implements LectureStorage {
    private final JdbcClient jdbcClient;

    public DatabaseLectureStorage(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public void store(String data) {
        jdbcClient.sql("INSERT INTO LECTURE(SERIALIZED_DATA) VALUES(?)")
                .param(1, data)
                .update();
    }
}