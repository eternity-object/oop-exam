package org.eternity.exam.serializer;

import org.eternity.exam.Lecture;

public interface LectureSerializer {
    FormatType key();
    String serialize(Lecture lecture) throws Exception;
}
