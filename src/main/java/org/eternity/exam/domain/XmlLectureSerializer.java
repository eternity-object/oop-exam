package org.eternity.exam.domain;

import org.eternity.exam.service.LectureReporter;
import org.springframework.stereotype.Component;

@Component
public class XmlLectureSerializer implements LectureSerializer {
    @Override
    public String serialize(Lecture lecture) {
        return String.format("<lecture><title>%s</title><date>%s</date><duration>%d</duration></lecture>",
                lecture.getTitle(),
                lecture.getDate(),
                lecture.getDays());
    }

}
