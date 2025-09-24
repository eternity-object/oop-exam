package org.eternity.exam;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

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
