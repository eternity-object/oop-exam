package org.eternity.exam.mapper;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.eternity.exam.Lecture;
import org.eternity.exam.type.FormatType;

public class CsvLectureMapper implements LectureMapper {

    private final CsvMapper mapper;
    private final CsvSchema schema;

    public CsvLectureMapper() {
        mapper = new CsvMapper();
        mapper.registerModule(new JavaTimeModule());
        schema = mapper.schemaFor(Lecture.class).withHeader();
    }

    @Override
    public String writeValueAsString(Lecture lecture) throws Exception {
        return mapper.writer(schema).writeValueAsString(lecture);
    }

    @Override
    public boolean isSatisfied(FormatType formatType) {
        return formatType == FormatType.CSV;
    }
}
