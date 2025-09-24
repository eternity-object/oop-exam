package org.eternity.exam;

import org.springframework.jdbc.core.simple.JdbcClient;

public class DbWriter implements Writer{

    private final JdbcClient jdbcClient;

    public DbWriter(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public void write(String serialized) throws Exception {
        jdbcClient.sql("INSERT INTO LECTURE(SERIALIZED_DATA) VALUES(?)")
            .param(1, serialized)
            .update();
    }
}
