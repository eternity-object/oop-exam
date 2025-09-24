package org.eternity.exam.lectureSerializer;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.eternity.exam.FormatType;
import org.eternity.exam.Lecture;
import org.eternity.exam.LectureSerializer;
import org.springframework.stereotype.Service;

@Service

public class CsvLectureSerializer implements LectureSerializer {
    private final FormatType formatType = FormatType.CSV;
    @Override
    public String serialized(Lecture lecture) throws Exception {
        CsvMapper mapper = new CsvMapper();
        mapper.registerModule(new JavaTimeModule());
        CsvSchema schema = mapper.schemaFor(Lecture.class).withHeader();
        return mapper.writer(schema).writeValueAsString(lecture);
    }

    @Override
    public boolean isType(FormatType type) {
        return type.equals(formatType);
    }
}
