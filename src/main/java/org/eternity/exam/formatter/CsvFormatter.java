package org.eternity.exam.formatter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.eternity.exam.Lecture;

public class CsvFormatter implements LectureFormatter{
    private final CsvMapper mapper;

    public CsvFormatter(){
        mapper = new CsvMapper();
        mapper.registerModule(new JavaTimeModule());
    }

    @Override
    public String serialize(Lecture lecture) throws JsonProcessingException {
        CsvSchema schema = mapper.schemaFor(Lecture.class).withHeader();
        return mapper.writer(schema).writeValueAsString(lecture);
    }
}
