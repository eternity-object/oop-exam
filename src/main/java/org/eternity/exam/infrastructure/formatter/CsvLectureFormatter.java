package org.eternity.exam.infrastructure.formatter;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.eternity.exam.domain.Lecture;
import org.springframework.stereotype.Component;

@Component
public class CsvLectureFormatter implements LectureFormatter {
    private final CsvMapper mapper;

    public CsvLectureFormatter() {
        this.mapper = new CsvMapper();
        this.mapper.registerModule(new JavaTimeModule());
    }

    @Override
    public String format(Lecture lecture) throws Exception {
        CsvSchema schema = mapper.schemaFor(Lecture.class).withHeader();
        return mapper.writer(schema).writeValueAsString(lecture);
    }
}