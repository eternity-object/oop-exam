package org.eternity.exam.service;

import org.eternity.exam.domain.Lecture;
import org.eternity.exam.domain.LectureSerializer;
import org.eternity.exam.domain.Storage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LectureReporter {
    public enum FormatType { JSON, CSV, XML }
    public enum StorageType { DATABASE, FILE }

    private final LectureSerializer serializer;
    private final Storage storage;

    public LectureReporter(LectureSerializer serializer, Storage storage) {
        this.serializer = serializer;
        this.storage = storage;
    }

    public void report(Lecture lecture) {
        String serialized = serializer.serialize(lecture);
        storage.save(serialized, lecture.getTitle());
    }
}
