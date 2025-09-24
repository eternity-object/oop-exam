package org.eternity.exam.formatter;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.eternity.exam.Lecture;

public interface LectureFormatter {
    String serialize(Lecture lecture) throws JsonProcessingException;
}
