package org.eternity.exam.storages;

import org.eternity.exam.LectureStorage;
import org.springframework.jdbc.core.simple.JdbcClient;

import java.io.IOException;

public class DatabaseLectureStorage implements LectureStorage {
    private JdbcClient jdbcClient;

    public DatabaseLectureStorage(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public void write(String content) throws IOException {
        jdbcClient.sql("INSERT INTO LECTURE(SERIALIZED_DATA) VALUES(?)")
                .param(1, content)
                .update();
    }
}
