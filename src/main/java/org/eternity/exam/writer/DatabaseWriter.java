package org.eternity.exam.writer;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class DatabaseWriter implements Writer {

    private final JdbcClient jdbcClient;

    @Override
    public void save(String serialized) throws IOException {
        jdbcClient.sql("INSERT INTO LECTURE(SERIALIZED_DATA) VALUES(?)")
                .param(1, serialized)
                .update();
    }
}
