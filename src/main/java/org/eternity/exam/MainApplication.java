package org.eternity.exam;

import org.eternity.exam.formatter.CsvFormatter;
import org.eternity.exam.formatter.JsonFormatter;
import org.eternity.exam.storage.DbStorage;
import org.eternity.exam.storage.FileStorage;
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


        Lecture oopLecture = new Lecture("객체지향 설계", LocalDate.of(2025, 9, 22), 3);

        LectureReporter reporter = new LectureReporter(new JsonFormatter(), new FileStorage());
        reporter.report(oopLecture);

        LectureReporter reporter1 = new LectureReporter(new CsvFormatter(), new DbStorage(jdbcClient));
        reporter1.report(oopLecture);
    }
}
