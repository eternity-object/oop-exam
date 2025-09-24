package org.eternity.exam.reporter;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.eternity.exam.AbstractReporter;
import org.eternity.exam.Lecture;
import org.springframework.jdbc.core.simple.JdbcClient;

public class CsvReporter extends AbstractReporter {

    private final Lecture lecture;

    public CsvReporter(JdbcClient jdbcClient, Lecture lecture) {
        super(jdbcClient);
        this.lecture = lecture;
    }

    @Override
    protected String convert() throws Exception {
        CsvMapper mapper = new CsvMapper();
        mapper.registerModule(new JavaTimeModule());
        CsvSchema schema = mapper.schemaFor(Lecture.class).withHeader();
        return mapper.writer(schema).writeValueAsString(lecture);
    }
}
