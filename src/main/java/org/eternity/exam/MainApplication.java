package org.eternity.exam;

import org.eternity.exam.format.JsonMapper;
import org.eternity.exam.storage.FileStorage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(MainApplication.class);
        LectureReporter reporter = new LectureReporter(new JsonMapper(), new FileStorage("lecture_data.txt"));
        reporter.report(new Lecture("객체지향 설계", LocalDate.of(2025, 9, 22), 3));
    }
}
