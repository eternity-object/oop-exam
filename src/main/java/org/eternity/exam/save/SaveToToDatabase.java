package org.eternity.exam.save;

import org.eternity.exam.LectureReporter.StorageType;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Component;

@Component
public class SaveToToDatabase implements SaveToStorage {

    private final JdbcClient jdbcClient;

    public SaveToToDatabase(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public boolean isSupport(StorageType storageType) {
        return storageType.equals(StorageType.DATABASE);
    }

    @Override
    public void save(String serialized) {
        jdbcClient.sql("INSERT INTO LECTURE(SERIALIZED_DATA) VALUES(?)")
                .param(1, serialized)
                .update();
    }
}
