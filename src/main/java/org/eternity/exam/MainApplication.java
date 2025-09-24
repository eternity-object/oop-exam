package org.eternity.exam;

import org.eternity.exam.formatters.CsvFormatter;
import org.eternity.exam.formatters.JsonFormatter;
import org.eternity.exam.formatters.XmlFormatter;
import org.eternity.exam.storages.DatabaseStorage;
import org.eternity.exam.storages.FileStorage;
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

        Formatter jsonFormatter = new JsonFormatter();
        Formatter xmlFormatter = new XmlFormatter();
        Formatter csvFormatter = new CsvFormatter();

        Storage databaseStorage = new DatabaseStorage(jdbcClient);
        Storage fileStorage = new FileStorage();

        LectureReporter reporter = new LectureReporter();
        reporter.report(
                jsonFormatter,
                databaseStorage,
                oop_design
        );
        reporter.report(
                jsonFormatter,
                fileStorage,
                oop_design
        );
        reporter.report(
                xmlFormatter,
                databaseStorage,
                oop_design
        );
        reporter.report(
                xmlFormatter,
                fileStorage,
                oop_design
        );
        reporter.report(
                csvFormatter,
                databaseStorage,
                oop_design
        );
        reporter.report(
                csvFormatter,
                fileStorage,
                oop_design
        );
    }
}
