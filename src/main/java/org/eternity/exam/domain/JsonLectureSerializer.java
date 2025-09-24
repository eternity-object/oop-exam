package org.eternity.exam.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component("jsonLectureSerializer")
public class JsonLectureSerializer implements LectureSerializer {
    private final ObjectMapper objectMapper = new ObjectMapper();
    public String serialize(Lecture lecture) {
        try { return objectMapper.writeValueAsString(lecture); }
        catch (Exception e) { throw new RuntimeException(e); }
    }
}
