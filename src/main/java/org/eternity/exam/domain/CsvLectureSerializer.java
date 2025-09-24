package org.eternity.exam.domain;

import org.eternity.exam.service.LectureReporter;
import org.springframework.stereotype.Component;

@Component
public class CsvLectureSerializer implements LectureSerializer {
    @Override
    public String serialize(Lecture lecture) {
        // [title,date,duration]
        return String.format("%s,%s,%d",
                lecture.getTitle(),
                lecture.getDate(),
                lecture.getDays());
    }

    public LectureReporter.FormatType getFormatType() {
        return LectureReporter.FormatType.CSV;
    }
}
