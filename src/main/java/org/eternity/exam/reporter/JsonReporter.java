package org.eternity.exam.reporter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.eternity.exam.AbstractReporter;
import org.eternity.exam.Lecture;
import org.springframework.jdbc.core.simple.JdbcClient;

public class JsonReporter extends AbstractReporter {

    private final Lecture lecture;

    public JsonReporter(JdbcClient jdbcClient, Lecture lecture) {
        super(jdbcClient);
        this.lecture = lecture;
    }

    @Override
    protected String convert() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper.writeValueAsString(lecture);
    }
}
