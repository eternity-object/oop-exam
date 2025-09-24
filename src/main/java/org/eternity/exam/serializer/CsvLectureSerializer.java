package org.eternity.exam.serializer;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.eternity.exam.Lecture;
import org.springframework.stereotype.Component;

@Component
public class CsvLectureSerializer implements LectureSerializer {
    private final CsvMapper mapper = (CsvMapper) new CsvMapper().registerModule(new JavaTimeModule());
    private final CsvSchema schema = mapper.schemaFor(Lecture.class).withHeader();

    @Override public FormatType key() { return FormatType.CSV; }

    @Override
    public String serialize(Lecture lecture) throws Exception {
        return mapper.writer(schema).writeValueAsString(lecture);
    }
}
