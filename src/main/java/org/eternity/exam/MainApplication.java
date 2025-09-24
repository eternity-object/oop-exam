package org.eternity.exam;

import org.eternity.exam.formatconverter.JsonConverter;
import org.eternity.exam.storagewriter.DatabaseWriter;
import org.eternity.exam.storagewriter.FileStorageWriter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.simple.JdbcClient;

import java.time.LocalDate;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) throws Exception {
        LectureReporter reporter = new LectureReporter(new JsonConverter(), new FileStorageWriter());
        reporter.report(new Lecture("객체지향 설계", LocalDate.of(2025, 9, 22), 3));
    }
}
