package org.eternity.exam.formatter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.eternity.exam.Lecture;

public class JsonFormatter implements LectureFormatter{
    private final ObjectMapper mapper;

    public JsonFormatter() {
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
    }

    @Override
    public String serialize(Lecture lecture) throws JsonProcessingException {
        return mapper.writeValueAsString(lecture);
    }
}
