package org.eternity.exam.serializer;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.eternity.exam.Lecture;
import org.springframework.stereotype.Component;

@Component
public class XmlLectureSerializer implements LectureSerializer {
    private final XmlMapper mapper = (XmlMapper) new XmlMapper().registerModule(new JavaTimeModule());

    @Override public FormatType key() { return FormatType.XML; }

    @Override
    public String serialize(Lecture lecture) throws Exception {
        return mapper.writeValueAsString(lecture);
    }
}
