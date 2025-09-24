package org.eternity.exam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.jdbc.core.simple.JdbcClient;

import java.io.FileWriter;
import java.io.IOException;

public class LectureReporter {
    public enum FormatType { JSON, CSV, XML }
    public enum StorageType { DATABASE, FILE }

    private final JdbcClient jdbcClient;

    public LectureReporter(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public void report(FormatType formatType, StorageType storageType, Lecture lecture) throws Exception {
        String serialized = serialize(formatType, lecture);
        save(storageType, serialized);
    }
//포맷변환(serialize) - SRP 단일책임원칙에 따름
    private String serialize(FormatType formatType, Lecture lecture) throws Exception {
        return switch (formatType) {
            case JSON -> serializeToJson(lecture);
            case CSV  -> serializeToCsv(lecture);
            case XML  -> serializeToXml(lecture);
        };
    }

    private String serializeToJson(Lecture lecture) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper.writeValueAsString(lecture);
    }

    private String serializeToCsv(Lecture lecture) throws Exception {
        CsvMapper mapper = new CsvMapper();
        mapper.registerModule(new JavaTimeModule());
        CsvSchema schema = mapper.schemaFor(Lecture.class).withHeader();
        return mapper.writer(schema).writeValueAsString(lecture);
    }

    private String serializeToXml(Lecture lecture) throws Exception {
        XmlMapper mapper = new XmlMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper.writeValueAsString(lecture);
    }
//저장 책임분리 - SRP 단일원칙에 따름
    private void save(StorageType storageType, String data) throws Exception {
        switch (storageType) {
            case DATABASE -> saveToDatabase(data);
            case FILE -> saveToFile(data);
        }
    }

    private void saveToDatabase(String data) {
        jdbcClient.sql("INSERT INTO LECTURE(SERIALIZED_DATA) VALUES(?)")
                .param(1, data)
                .update();
    }

    private void saveToFile(String data) throws IOException {
        try (FileWriter writer = new FileWriter("lecture_data.txt")) {
            writer.write(data);
        }
    }
}
