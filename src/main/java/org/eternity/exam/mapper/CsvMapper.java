package org.eternity.exam.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.eternity.exam.Lecture;
import org.springframework.stereotype.Component;

@Component
public class CsvMapper implements Mapper {

    @Override
    public String serialize(Lecture lecture) throws JsonProcessingException {
        com.fasterxml.jackson.dataformat.csv.CsvMapper mapper = new com.fasterxml.jackson.dataformat.csv.CsvMapper();
        mapper.registerModule(new JavaTimeModule());
        CsvSchema schema = mapper.schemaFor(Lecture.class).withHeader();
        return mapper.writer(schema).writeValueAsString(lecture);
    }
}
