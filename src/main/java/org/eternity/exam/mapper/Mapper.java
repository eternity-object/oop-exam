package org.eternity.exam.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.eternity.exam.Lecture;

public interface Mapper {
    String serialize(Lecture lecture) throws JsonProcessingException;
}
