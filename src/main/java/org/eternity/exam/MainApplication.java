package org.eternity.exam;

import org.eternity.exam.LectureReporter.StorageType;
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

        LectureReporter reporter = new LectureReporter(jdbcClient, new CsvFormatter());
        reporter.report(
                StorageType.FILE,
                new Lecture("객체지향 설계", LocalDate.of(2025, 9, 22), 3));
    }
}
