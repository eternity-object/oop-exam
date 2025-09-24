package org.eternity.exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(MainApplication.class, args);
        LectureReporter reporter = ctx.getBean(LectureReporter.class);

        // 노션 예시와 동일 포맷 검증용(필요한 것만 호출)
        Lecture lecture = new Lecture("객체지향 설계", LocalDate.of(2025, 9, 22), 3);

        reporter.report(LectureReporter.FormatType.JSON, LectureReporter.StorageType.FILE, lecture);
        reporter.report(LectureReporter.FormatType.CSV,  LectureReporter.StorageType.FILE, lecture);
        reporter.report(LectureReporter.FormatType.XML,  LectureReporter.StorageType.FILE, lecture);
    }
}
