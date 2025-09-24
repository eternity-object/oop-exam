package org.eternity.exam;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface Formatter {
    String serialize(Lecture lecture) throws JsonProcessingException;
}
