package org.eternity.exam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class CsvConverter implements Converter {

    public String convert(Lecture lecture) throws JsonProcessingException {
        String serialized;
        CsvMapper mapper = new CsvMapper();
        mapper.registerModule(new JavaTimeModule());

        CsvSchema schema = mapper.schemaFor(Lecture.class).withHeader();
        serialized = mapper.writer(schema).writeValueAsString(lecture);

        return serialized;
    }
}
