package org.eternity.exam.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.eternity.exam.Lecture;
import org.eternity.exam.LectureReporter.FormatType;
import org.springframework.stereotype.Component;

@Component
public class JsonFormatSerializer implements FormatSerializer{

    public boolean isSupport(FormatType formatType){
        return formatType.equals(FormatType.JSON);
    }

    @Override
    public String serialized(Lecture lecture) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper.writeValueAsString(lecture);
    }
}
