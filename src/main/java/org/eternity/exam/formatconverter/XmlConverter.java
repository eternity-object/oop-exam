package org.eternity.exam.formatconverter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.eternity.exam.Lecture;

public class XmlConverter implements FormatConverter{

    @Override
    public String convert(Lecture lecture) throws JsonProcessingException {
        XmlMapper mapper = new XmlMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper.writeValueAsString(lecture);
    }
}
