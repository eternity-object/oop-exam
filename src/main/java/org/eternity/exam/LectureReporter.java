package org.eternity.exam;

import org.springframework.jdbc.core.simple.JdbcClient;

import java.io.FileWriter;

public class LectureReporter {

    public void report(Formatter formatter, Storage storage, Lecture lecture) throws Exception {

        // 포맷 변환
        String serialized = formatter.serialize(lecture);

        //  저장
        storage.write(serialized);
    }
}
