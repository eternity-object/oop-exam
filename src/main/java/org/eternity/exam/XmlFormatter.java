package org.eternity.exam;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Component;

@Component
public class XmlFormatter extends AbstractFormatter {
    private final XmlMapper mapper;

    protected XmlFormatter() {
        super(FormatType.XML);
        this.mapper = createMapper();
    }

    private XmlMapper createMapper() {
        XmlMapper mapper = new XmlMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper;
    }

    @Override
    public String formatToString(Lecture lecture) throws Exception {
        return mapper.writeValueAsString(lecture);
    }
}
