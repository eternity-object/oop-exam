package org.eternity.exam.format;

import org.eternity.exam.Lecture;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class CsvMapper implements FormatMapper {

	private final com.fasterxml.jackson.dataformat.csv.CsvMapper mapper;

	public CsvMapper() {
		mapper = new com.fasterxml.jackson.dataformat.csv.CsvMapper();
		mapper.registerModule(new JavaTimeModule());
	}

	@Override
	public String format(Lecture lecture) throws JsonProcessingException {
		CsvSchema schema = mapper.schemaFor(Lecture.class).withHeader();
		return mapper.writer(schema).writeValueAsString(lecture);
	}
}
