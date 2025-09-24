package org.eternity.exam.format;

import org.eternity.exam.Lecture;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface FormatMapper {
	String format(Lecture lecture) throws JsonProcessingException;
}
