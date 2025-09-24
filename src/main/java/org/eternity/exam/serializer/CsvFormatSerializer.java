package org.eternity.exam.serializer;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.eternity.exam.Lecture;
import org.eternity.exam.LectureReporter.FormatType;
import org.springframework.stereotype.Component;

@Component
public class CsvFormatSerializer implements FormatSerializer{

    public boolean isSupport(FormatType formatType){
        return formatType.equals(FormatType.CSV);
    }

    @Override
    public String serialized(Lecture lecture) throws Exception {
        CsvMapper mapper = new CsvMapper();
        mapper.registerModule(new JavaTimeModule());
        CsvSchema schema = mapper.schemaFor(Lecture.class).withHeader();
        return mapper.writer(schema).writeValueAsString(lecture);
    }
}
