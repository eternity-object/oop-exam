package org.eternity.exam;

import org.eternity.exam.mapper.CsvLectureMapper;
import org.eternity.exam.mapper.JSONLectureMapper;
import org.eternity.exam.mapper.LectureMapper;
import org.eternity.exam.mapper.XMLLectureMapper;
import org.eternity.exam.storage.DatabaseStorage;
import org.eternity.exam.storage.FileStorage;
import org.eternity.exam.storage.LectureStorage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.simple.JdbcClient;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.eternity.exam.type.FormatType.JSON;
import static org.eternity.exam.type.StorageType.FILE;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(MainApplication.class);
        JdbcClient jdbcClient = context.getBean(JdbcClient.class);

        List<LectureMapper> mappers = Arrays.asList(
            new JSONLectureMapper(),
            new XMLLectureMapper(),
            new CsvLectureMapper()
        );

        List<LectureStorage> storages = Arrays.asList(
            new FileStorage(),
            new DatabaseStorage(jdbcClient)
        );


        LectureReporter reporter = new LectureReporter(mappers, storages);
        reporter.report(
                JSON,
                FILE,
                new Lecture("객체지향 설계", LocalDate.of(2025, 9, 22), 3));
    }
}
