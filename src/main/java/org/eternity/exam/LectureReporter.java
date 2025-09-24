package org.eternity.exam;

public class LectureReporter {

    private final Recoder recoder;

    public LectureReporter(Recoder recoder) {
        this.recoder = recoder;
    }

    public void report(Lecture lecture) throws Exception {
        recoder.record(lecture);
    }
}
