package org.eternity.exam.infrastructure.formatter;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.eternity.exam.domain.Lecture;
import org.springframework.stereotype.Component;

@Component
public class XmlLectureFormatter implements LectureFormatter {
    private final XmlMapper mapper;

    public XmlLectureFormatter() {
        this.mapper = new XmlMapper();
        this.mapper.registerModule(new JavaTimeModule());
    }

    @Override
    public String format(Lecture lecture) throws Exception {
        return mapper.writeValueAsString(lecture);
    }
}