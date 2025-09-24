package org.eternity.exam;

import org.eternity.exam.mapper.Mapper;
import org.eternity.exam.mapper.MapperFactory;
import org.eternity.exam.type.FormatType;
import org.eternity.exam.type.StorageType;
import org.eternity.exam.writer.WriterFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Component;

@Component
public class LectureReporter {

    private final JdbcClient jdbcClient;

    public LectureReporter(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public void report(FormatType formatType, StorageType storageType, Lecture lecture) throws Exception {
        // 포맷 변환
        Mapper mapper = MapperFactory.getMapper(formatType);
        String serialized = mapper.serialize(lecture);

        //  저장
        WriterFactory writerFactory = new WriterFactory(jdbcClient);
        writerFactory.getWriter(storageType).save(serialized);
    }
}
