package org.eternity.exam;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface LectureSerializer {
    String serialize(Lecture lecture) throws JsonProcessingException;
}
