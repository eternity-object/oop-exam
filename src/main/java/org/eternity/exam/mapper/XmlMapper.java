package org.eternity.exam.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.eternity.exam.Lecture;
import org.springframework.stereotype.Component;

@Component
public class XmlMapper implements Mapper {
    @Override
    public String serialize(Lecture lecture) throws JsonProcessingException {
        com.fasterxml.jackson.dataformat.xml.XmlMapper mapper = new com.fasterxml.jackson.dataformat.xml.XmlMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper.writeValueAsString(lecture);
    }
}
