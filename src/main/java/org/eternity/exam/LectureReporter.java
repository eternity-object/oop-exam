package org.eternity.exam;

public class LectureReporter {

    public void report(LectureFormatter lectureFormatter, LectureStorage lectureStorage, Lecture lecture) throws Exception {

        // 포맷 변환
        String serialized = lectureFormatter.serialize(lecture);

        //  저장
        lectureStorage.write(serialized);
    }
}
