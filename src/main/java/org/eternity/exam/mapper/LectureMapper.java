package org.eternity.exam.mapper;

import org.eternity.exam.Lecture;
import org.eternity.exam.type.FormatType;

public interface LectureMapper {
    String writeValueAsString(Lecture lecture) throws Exception;

    boolean isSatisfied(FormatType formatType);
}
