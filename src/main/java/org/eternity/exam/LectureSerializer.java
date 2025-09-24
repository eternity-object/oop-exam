package org.eternity.exam;

import org.springframework.stereotype.Service;

@Service

public interface LectureSerializer {
    String serialized(Lecture lecture) throws Exception;

    boolean isType(FormatType type);

}
