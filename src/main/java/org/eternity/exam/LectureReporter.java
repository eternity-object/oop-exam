package org.eternity.exam;


public class LectureReporter {
    private final LectureFormatter formatter;
    private final LectureStorage storage;

    public LectureReporter(LectureFormatter formatter, LectureStorage storage) {
        this.formatter = formatter;
        this.storage = storage;
    }

    public void report(Lecture lecture) throws Exception {
        String serialized = formatter.format(lecture);
        storage.store(serialized);
    }
}
