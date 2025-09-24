package org.eternity.exam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConverter extends Converter {

    protected JsonConverter(ObjectMapper mapper) {
        super(mapper);
    }

    @Override
    protected String serialize(Lecture lecture) throws JsonProcessingException {
        return mapper.writeValueAsString(lecture);
    }
}
