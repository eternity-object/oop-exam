package org.eternity.exam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class XmlConverter implements Converter {

    public String convert(Lecture lecture) throws JsonProcessingException {
        String serialized;
        XmlMapper mapper = new XmlMapper();
        mapper.registerModule(new JavaTimeModule());

        serialized = mapper.writeValueAsString(lecture);

        return serialized;
    }
}
