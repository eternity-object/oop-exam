package org.eternity.exam;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Component;

@Component
public class DbWriter implements Writer{

    private final JdbcClient jdbcClient;

    protected DbWriter(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public void write(String serialized) throws Exception {
        jdbcClient.sql("INSERT INTO LECTURE(SERIALIZED_DATA) VALUES(?)")
            .param(1, serialized)
            .update();
    }

    @Override
    public boolean supports(StorageType storageType) {
        return StorageType.DATABASE.equals(storageType);
    }
}

