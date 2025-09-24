package org.eternity.exam;

import org.eternity.exam.formatter.LectureFormatter;
import org.eternity.exam.storage.LectureStorage;

public class LectureReporter {
    private final LectureFormatter lectureFormatter;
    private final LectureStorage lectureStorage;


    public LectureReporter(LectureFormatter lectureFormatter, LectureStorage lectureStorage) {
        this.lectureFormatter = lectureFormatter;
        this.lectureStorage = lectureStorage;
    }

    public void report(Lecture lecture) throws Exception {
        String serialized = lectureFormatter.serialize(lecture);
        lectureStorage.save(serialized);
    }
}
