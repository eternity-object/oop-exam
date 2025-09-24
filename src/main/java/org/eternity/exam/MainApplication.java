package org.eternity.exam;

import org.eternity.exam.serializer.FormatType;
import org.eternity.exam.storage.StorageType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext ctx = SpringApplication.run(MainApplication.class, args);

        LectureReporter reporter = ctx.getBean(LectureReporter.class);
        reporter.report(
                FormatType.JSON,
                StorageType.FILE,
                new Lecture("OOP", java.time.LocalDate.of(2025, 9, 22), 3)
        );
    }
}
