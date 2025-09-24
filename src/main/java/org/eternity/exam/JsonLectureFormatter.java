package org.eternity.exam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JsonLectureFormatter implements LectureFormatter {
    private final ObjectMapper mapper;

    public JsonLectureFormatter() {
        this.mapper = new ObjectMapper();
        this.mapper.registerModule(new JavaTimeModule());
    }

    @Override
    public String format(Lecture lecture) throws Exception {
        return mapper.writeValueAsString(lecture);
    }
}
