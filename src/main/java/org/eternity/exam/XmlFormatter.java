package org.eternity.exam;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class XmlFormatter extends AbstractFormatter {

    protected XmlFormatter() {
        super(FormatType.XML);
    }

    @Override
    public String formatToString(Lecture lecture) throws Exception {
        XmlMapper mapper = new XmlMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper.writeValueAsString(lecture);
    }
}
