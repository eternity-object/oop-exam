package org.eternity.exam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JsonConverter implements Converter {

    public String convert(Lecture lecture) throws JsonProcessingException {
        String serialized;
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        serialized = mapper.writeValueAsString(lecture);

        return serialized;
    }
}
