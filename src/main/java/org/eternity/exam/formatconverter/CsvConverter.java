package org.eternity.exam.formatconverter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.eternity.exam.Lecture;

public class CsvConverter implements FormatConverter{

    @Override
    public String convert(Lecture lecture) throws JsonProcessingException {
        CsvMapper mapper = new CsvMapper();
        mapper.registerModule(new JavaTimeModule());
        CsvSchema schema = mapper.schemaFor(Lecture.class).withHeader();
        return mapper.writer(schema).writeValueAsString(lecture);
    }
}
