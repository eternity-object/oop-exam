package org.eternity.exam;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface LectureFormatter {
    String serialize(Lecture lecture) throws JsonProcessingException;
}
