package org.eternity.exam.lectureSerializer;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.eternity.exam.FormatType;
import org.eternity.exam.Lecture;
import org.eternity.exam.LectureSerializer;
import org.springframework.stereotype.Service;

@Service

public class XmlLectureSerializer implements LectureSerializer {

    private final FormatType formatType = FormatType.XML;

    @Override
    public String serialized(Lecture lecture) throws Exception {
        XmlMapper mapper = new XmlMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper.writeValueAsString(lecture);
    }

    @Override
    public boolean isType(FormatType type) {
        return type.equals(formatType);
    }
}
