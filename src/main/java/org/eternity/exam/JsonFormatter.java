package org.eternity.exam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JsonFormatter extends AbstractFormatter {

    protected JsonFormatter() {
        super(FormatType.JSON);
    }

    @Override
    public String formatToString(Lecture lecture) throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper.writeValueAsString(lecture);
    }
}
