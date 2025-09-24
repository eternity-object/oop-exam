package org.eternity.exam.lectureSaver;

import lombok.RequiredArgsConstructor;
import org.eternity.exam.LectureSaver;
import org.eternity.exam.StorageType;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DBLectureSaver implements LectureSaver {

    private final StorageType storageType = StorageType.DATABASE;

    private final JdbcClient jdbcClient;
    @Override
    public void save(String serialized) {
        jdbcClient.sql("INSERT INTO LECTURE(SERIALIZED_DATA) VALUES(?)")
                .param(1, serialized)
                .update();
    }

    @Override
    public boolean isType(StorageType type) {
        return type.equals(storageType);
    }
}
