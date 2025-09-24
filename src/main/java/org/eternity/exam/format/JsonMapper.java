package org.eternity.exam.format;

import org.eternity.exam.Lecture;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JsonMapper implements FormatMapper {

	private final ObjectMapper mapper;

	public JsonMapper() {
		mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
	}

	@Override
	public String format(Lecture lecture) throws JsonProcessingException {
		return mapper.writeValueAsString(lecture);
	}
}
