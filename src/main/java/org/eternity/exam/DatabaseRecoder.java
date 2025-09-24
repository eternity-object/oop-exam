package org.eternity.exam;

import org.springframework.jdbc.core.simple.JdbcClient;

public class DatabaseRecoder extends Recoder {

    private final JdbcClient jdbcClient;

    public DatabaseRecoder(Converter converter, JdbcClient jdbcClient) {
        super(converter);
        this.jdbcClient = jdbcClient;
    }

    @Override
    public void save(String serialized) {
        jdbcClient.sql("INSERT INTO LECTURE(SERIALIZED_DATA) VALUES(?)")
                .param(1, serialized)
                .update();
    }
}
