package org.eternity.exam.service;

import org.eternity.exam.common.FormatType;
import org.eternity.exam.common.StorageType;
import org.eternity.exam.domain.Lecture;
import org.eternity.exam.infrastructure.formatter.LectureFormatter;
import org.eternity.exam.infrastructure.formatter.LectureFormatterFactory;
import org.eternity.exam.infrastructure.storage.LectureStorage;
import org.eternity.exam.infrastructure.storage.LectureStorageFactory;
import org.springframework.stereotype.Component;

@Component
public class LectureReporter {
    private final LectureFormatterFactory formatterFactory;
    private final LectureStorageFactory storageFactory;

    public LectureReporter(
            LectureFormatterFactory formatterFactory,
            LectureStorageFactory storageFactory) {
        this.formatterFactory = formatterFactory;
        this.storageFactory = storageFactory;
    }

    public void report(FormatType formatType, StorageType storageType, Lecture lecture) throws Exception {
        // 포맷 변환
        LectureFormatter formatter = formatterFactory.getFormatter(formatType);
        String serialized = formatter.format(lecture);

        // 저장
        LectureStorage storage = storageFactory.getStorage(storageType);
        storage.store(serialized);
    }
}