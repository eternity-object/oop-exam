package org.eternity.exam.writer;

import org.springframework.jdbc.core.simple.JdbcClient;

public class DatabaseWriter implements Writer {
    private final JdbcClient jdbcClient;

    public DatabaseWriter(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public void write(String str) {
        jdbcClient.sql("INSERT INTO LECTURE(SERIALIZED_DATA) VALUES(?)")
            .param(1, str)
            .update();
    }
}
