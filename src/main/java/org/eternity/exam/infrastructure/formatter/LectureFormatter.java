package org.eternity.exam.infrastructure.formatter;

import org.eternity.exam.domain.Lecture;

public interface LectureFormatter {
    String format(Lecture lecture) throws Exception;
}