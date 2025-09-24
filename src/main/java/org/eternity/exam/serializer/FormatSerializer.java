package org.eternity.exam.serializer;

import org.eternity.exam.Lecture;
import org.eternity.exam.LectureReporter.FormatType;

public interface FormatSerializer
{
    boolean isSupport(FormatType formatType);
    String serialized(Lecture lecture) throws Exception;
}
