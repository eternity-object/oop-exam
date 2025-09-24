package org.eternity.exam.storages;

import org.eternity.exam.Storage;
import org.springframework.jdbc.core.simple.JdbcClient;

import java.io.IOException;

public class DatabaseStorage implements Storage {
    private JdbcClient jdbcClient;

    public DatabaseStorage(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public void write(String content) throws IOException {
        jdbcClient.sql("INSERT INTO LECTURE(SERIALIZED_DATA) VALUES(?)")
                .param(1, content)
                .update();
    }
}
