package org.eternity.exam.format;

import org.eternity.exam.Lecture;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class XmlMapper implements FormatMapper {

	private final com.fasterxml.jackson.dataformat.xml.XmlMapper mapper;

	public XmlMapper() {
		mapper = new com.fasterxml.jackson.dataformat.xml.XmlMapper();
		mapper.registerModule(new JavaTimeModule());
	}

	@Override
	public String format(Lecture lecture) throws JsonProcessingException {
		return mapper.writeValueAsString(lecture);
	}
}
