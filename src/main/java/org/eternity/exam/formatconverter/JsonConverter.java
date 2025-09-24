package org.eternity.exam.formatconverter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.eternity.exam.Lecture;

public class JsonConverter implements FormatConverter {

    @Override
    public String convert(Lecture lecture) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper.writeValueAsString(lecture);
    }
}
