package org.eternity.exam;

public class LectureReporter {
    private final LectureFormatter lectureFormatter;
    private final LectureStorage lectureStorage;

    public LectureReporter(LectureFormatter lectureFormatter, LectureStorage lectureStorage) {
        this.lectureFormatter = lectureFormatter;
        this.lectureStorage = lectureStorage;
    }


    public void report(Lecture lecture) throws Exception {

        // 포맷 변환
        String serialized = lectureFormatter.serialize(lecture);

        //  저장
        lectureStorage.write(serialized);
    }
}
