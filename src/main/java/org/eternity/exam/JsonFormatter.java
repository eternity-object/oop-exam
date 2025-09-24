package org.eternity.exam;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Component;

@Component
public class JsonFormatter extends AbstractFormatter {
    private final JsonMapper mapper;

    public JsonFormatter() {
        super(FormatType.JSON);
        this.mapper = createMapper();
    }

    private JsonMapper createMapper() {
        JsonMapper mapper = new JsonMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper;
    }

    @Override
    public String formatToString(Lecture lecture) throws Exception{
        return mapper.writeValueAsString(lecture);
    }
}
