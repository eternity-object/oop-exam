package org.eternity.exam.storagewriter;

import org.springframework.jdbc.core.simple.JdbcClient;

public class DatabaseWriter implements StorageWriter{

    private final JdbcClient jdbcClient;

    public DatabaseWriter(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public void write(String content) {
        jdbcClient.sql("INSERT INTO LECTURE(SERIALIZED_DATA) VALUES(?)")
                .param(1, content)
                .update();
    }
}
