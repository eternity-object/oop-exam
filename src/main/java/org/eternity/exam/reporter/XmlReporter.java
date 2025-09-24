package org.eternity.exam.reporter;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.eternity.exam.AbstractReporter;
import org.eternity.exam.Lecture;
import org.springframework.jdbc.core.simple.JdbcClient;

public class XmlReporter extends AbstractReporter {

    private final Lecture lecture;

    public XmlReporter(JdbcClient jdbcClient, Lecture lecture) {
        super(jdbcClient);
        this.lecture = lecture;
    }

    @Override
    protected String convert() throws Exception {
        XmlMapper mapper = new XmlMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper.writeValueAsString(lecture);
    }
}
