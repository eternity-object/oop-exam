package org.eternity.exam.formatconverter;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.eternity.exam.Lecture;

public interface FormatConverter {

    String convert(Lecture lecture) throws JsonProcessingException;
}
