package org.eternity.exam;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Component;

@Component
public class CsvFormatter extends AbstractFormatter {
    private final CsvMapper mapper;

    public CsvFormatter() {
        super(FormatType.CSV);
        this.mapper = createMapper();
    }

    private CsvMapper createMapper() {
        CsvMapper mapper = new CsvMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper;
    }

    @Override
    public String formatToString(Lecture lecture) throws Exception {
        CsvSchema schema = mapper.schemaFor(Lecture.class).withHeader();
        return mapper.writer(schema).writeValueAsString(lecture);
    }
}
