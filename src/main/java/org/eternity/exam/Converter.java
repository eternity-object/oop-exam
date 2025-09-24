package org.eternity.exam;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface Converter {

    String convert(Lecture lecture) throws JsonProcessingException;
}
