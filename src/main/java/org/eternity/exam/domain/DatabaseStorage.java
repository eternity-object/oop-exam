package org.eternity.exam.domain;


import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Component;

@Component("databaseStorage")
public class DatabaseStorage implements Storage {
    private final JdbcClient jdbcClient;
    public DatabaseStorage(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }
    public void save(String data, String sourceName) {
        // DB 저장 로직 작성 (예시)
        jdbcClient.insertLecture(sourceName, data);
        System.out.println("[DB] 저장 완료: " + sourceName);
    }
}
