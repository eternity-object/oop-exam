package org.eternity.exam;

import com.fasterxml.jackson.core.JsonProcessingException;

public class LectureReporter {

    private final LectureStorage lectureStorage;
    private final LectureSerializer lectureSerializer;

    public LectureReporter(LectureSerializer lectureSerializer, LectureStorage lectureStorage) {
        this.lectureSerializer = lectureSerializer;
        this.lectureStorage = lectureStorage;
    }

    public void report(Lecture lecture) throws JsonProcessingException {
        var serializedLecture = lectureSerializer.serialize(lecture);
        lectureStorage.save(serializedLecture);
    }
}
