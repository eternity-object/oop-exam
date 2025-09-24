package org.eternity.exam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.jdbc.core.simple.JdbcClient;

import java.io.FileWriter;

public class LectureReporter {
    public enum StorageType { DATABASE, FILE }

    private final JdbcClient jdbcClient;
    private final Formatter formatter;

    public LectureReporter(JdbcClient jdbcClient, Formatter formatter) {
        this.jdbcClient = jdbcClient;
        this.formatter = formatter;
    }

    public void report(StorageType storageType, Lecture lecture) throws Exception {
        String serialized = formatter.formatToString(lecture);

        //  저장
        switch (storageType) {
            case DATABASE -> {
                jdbcClient.sql("INSERT INTO LECTURE(SERIALIZED_DATA) VALUES(?)")
                        .param(1, serialized)
                        .update();
            }
            case FILE -> {
                try (FileWriter writer = new FileWriter("lecture_data.txt")) {
                    writer.write(serialized);
                }
            }
        }
    }
}
