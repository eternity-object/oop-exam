package org.eternity.exam;

import org.springframework.jdbc.core.simple.JdbcClient;

public class DataBaseLectureStorage implements LectureStorage {

    private final JdbcClient jdbcClient;

    public DataBaseLectureStorage(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public void save(String serializedLecture) {
        jdbcClient.sql("INSERT INTO LECTURE(SERIALIZED_DATA) VALUES(?)")
                .param(1, serializedLecture)
                .update();
    }
}
