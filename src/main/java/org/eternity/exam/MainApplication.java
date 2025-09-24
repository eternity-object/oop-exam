package org.eternity.exam;

import org.eternity.exam.formatters.CsvLectureFormatter;
import org.eternity.exam.formatters.JsonLectureFormatter;
import org.eternity.exam.formatters.XmlLectureFormatter;
import org.eternity.exam.storages.DatabaseLectureStorage;
import org.eternity.exam.storages.FileLectureStorage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.simple.JdbcClient;

import java.time.LocalDate;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(MainApplication.class);
        JdbcClient jdbcClient = context.getBean(JdbcClient.class);

        Lecture oop_design = new Lecture("객체지향 설계", LocalDate.of(2025, 9, 22), 3);

        LectureFormatter jsonLectureFormatter = new JsonLectureFormatter();
        LectureFormatter xmlLectureFormatter = new XmlLectureFormatter();
        LectureFormatter csvLectureFormatter = new CsvLectureFormatter();

        LectureStorage databaseLectureStorage = new DatabaseLectureStorage(jdbcClient);
        LectureStorage fileLectureStorage = new FileLectureStorage();

        LectureReporter reporter = new LectureReporter();
        reporter.report(
                jsonLectureFormatter,
                databaseLectureStorage,
                oop_design
        );
        reporter.report(
                jsonLectureFormatter,
                fileLectureStorage,
                oop_design
        );
        reporter.report(
                xmlLectureFormatter,
                databaseLectureStorage,
                oop_design
        );
        reporter.report(
                xmlLectureFormatter,
                fileLectureStorage,
                oop_design
        );
        reporter.report(
                csvLectureFormatter,
                databaseLectureStorage,
                oop_design
        );
        reporter.report(
                csvLectureFormatter,
                fileLectureStorage,
                oop_design
        );
    }
}
