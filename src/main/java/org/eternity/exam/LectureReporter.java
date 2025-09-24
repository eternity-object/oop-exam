package org.eternity.exam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import org.eternity.exam.format.FormatMapper;
import org.eternity.exam.storage.Storage;
import org.springframework.jdbc.core.simple.JdbcClient;

import java.io.FileWriter;
import java.io.IOException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LectureReporter {

    private final FormatMapper formatMapper;
    private final Storage storage;

    public void report(Lecture lecture) throws Exception {
        String serialized = formatMapper.format(lecture);
        storage.save(serialized);
    }
}
