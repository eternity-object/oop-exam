package org.eternity.exam.storage;

import org.springframework.jdbc.core.simple.JdbcClient;

public class DbStorage implements LectureStorage{

    private final JdbcClient jdbcClient;

    public DbStorage(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public void save(String serialized) {
        jdbcClient.sql("INSERT INTO LECTURE(SERIALIZED_DATA) VALUES(?)")
                .param(1, serialized)
                .update();
    }
}
