package org.eternity.exam;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class CsvLectureFormatter implements LectureFormatter {
    private final CsvMapper mapper;
    private final CsvSchema schema;

    public CsvLectureFormatter() {
        this.mapper = new CsvMapper();
        this.mapper.registerModule(new JavaTimeModule());
        this.schema = mapper.schemaFor(Lecture.class).withHeader();
    }

    @Override
    public String format(Lecture lecture) throws Exception {
        return mapper.writer(schema).writeValueAsString(lecture);
    }
}
