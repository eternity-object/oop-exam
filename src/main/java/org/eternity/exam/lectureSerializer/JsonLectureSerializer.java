package org.eternity.exam.lectureSerializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.eternity.exam.FormatType;
import org.eternity.exam.Lecture;
import org.eternity.exam.LectureSerializer;
import org.springframework.stereotype.Service;

@Service

public class JsonLectureSerializer implements LectureSerializer {

    private final FormatType formatType = FormatType.JSON;

    @Override
    public String serialized(Lecture lecture) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper.writeValueAsString(lecture);
    }

    @Override
    public boolean isType(FormatType type) {
        return type.equals(formatType);
    }
}
