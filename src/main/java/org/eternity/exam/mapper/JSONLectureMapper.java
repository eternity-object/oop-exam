package org.eternity.exam.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.eternity.exam.Lecture;
import org.eternity.exam.type.FormatType;

public class JSONLectureMapper implements LectureMapper {
    private final ObjectMapper mapper;

    public JSONLectureMapper() {
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
    }

    @Override
    public String writeValueAsString(Lecture lecture) throws Exception {
        return mapper.writeValueAsString(lecture);
    }

    @Override
    public boolean isSatisfied(FormatType formatType) {
        return formatType == FormatType.JSON;
    }
}
