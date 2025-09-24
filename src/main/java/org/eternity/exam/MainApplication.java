package org.eternity.exam;

import java.time.LocalDate;
import org.eternity.exam.LectureReporter.StorageType;
import org.eternity.exam.reporter.JsonReporter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.simple.JdbcClient;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(MainApplication.class);
        JdbcClient jdbcClient = context.getBean(JdbcClient.class);

        Lecture lecture = new Lecture("객체지향 설계", LocalDate.of(2025, 9, 22), 3);

        JsonReporter jsonReporter = new JsonReporter(jdbcClient, lecture);
        jsonReporter.report(StorageType.FILE);
    }
}
