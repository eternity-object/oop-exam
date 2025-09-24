package org.eternity.exam.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.eternity.exam.LectureFormatter;
import org.eternity.exam.Lecture;

public class XmlLectureFormatter implements LectureFormatter {
    private final XmlMapper mapper;

    public XmlLectureFormatter(){
        mapper = new XmlMapper();
        mapper.registerModule(new JavaTimeModule());
    }

    @Override
    public String serialize(Lecture lecture) throws JsonProcessingException {
        return mapper.writeValueAsString(lecture);
    }
}
