package org.eternity.exam.save;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.eternity.exam.Lecture;
import org.eternity.exam.LectureReporter.FormatType;
import org.eternity.exam.serializer.FormatSerializer;
import org.springframework.stereotype.Component;

@Component
public class XMLFormatSerializer implements FormatSerializer {

    public boolean isSupport(FormatType formatType){
        return formatType.equals(FormatType.XML);
    }

    @Override
    public String serialized(Lecture lecture) throws Exception {
        XmlMapper mapper = new XmlMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper.writeValueAsString(lecture);
    }
}
