package org.eternity.exam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class XmlConverter extends Converter {

    public XmlConverter(ObjectMapper mapper) {
        super(mapper);
    }

    @Override
    protected String serialize(Lecture lecture) throws JsonProcessingException {
        return mapper.writeValueAsString(lecture);
    }
}
