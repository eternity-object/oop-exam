package org.eternity.exam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public class CsvConverter extends Converter {

    protected CsvConverter(ObjectMapper mapper) {
        super(mapper);
    }

    @Override
    public String serialize(Lecture lecture) throws JsonProcessingException {
        CsvMapper csvMapper = (CsvMapper) mapper;
        CsvSchema schema = csvMapper.schemaFor(Lecture.class).withHeader();

        return csvMapper.writer(schema).writeValueAsString(lecture);
    }
}
