package org.eternity.exam;

import org.springframework.jdbc.core.simple.JdbcClient;

public class DatabaseLectureStorage implements LectureStorage {
    private final JdbcClient jdbcClient;

    public DatabaseLectureStorage(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public void store(String data) throws Exception {
        jdbcClient.sql("INSERT INTO LECTURE(SERIALIZED_DATA) VALUES(?)")
                .param(1, data)
                .update();
    }
}
