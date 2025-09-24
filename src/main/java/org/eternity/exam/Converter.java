package org.eternity.exam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public abstract class Converter {

    protected final ObjectMapper mapper;

    protected Converter(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public String convert(Lecture lecture) {
        try {
            mapper.registerModule(new JavaTimeModule());

            return serialize(lecture);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected abstract String serialize(Lecture lecture) throws JsonProcessingException;
}
