package org.eternity.exam.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.eternity.exam.Lecture;
import org.springframework.stereotype.Component;

@Component
public class JsonLectureSerializer implements LectureSerializer {
    private final ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

    @Override public FormatType key() { return FormatType.JSON; }

    @Override
    public String serialize(Lecture lecture) throws Exception {
        return mapper.writeValueAsString(lecture);
    }
}
