package org.eternity.exam.mapper;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.eternity.exam.Lecture;
import org.eternity.exam.type.FormatType;

public class XMLLectureMapper implements LectureMapper {

    private final XmlMapper mapper;

    public XMLLectureMapper() {
        mapper = new XmlMapper();
        mapper.registerModule(new JavaTimeModule());
    }

    @Override
    public String writeValueAsString(Lecture lecture) throws Exception {
        return mapper.writeValueAsString(lecture);
    }

    @Override
    public boolean isSatisfied(FormatType formatType) {
        return formatType == FormatType.XML;
    }
}
