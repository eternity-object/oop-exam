package org.eternity.exam;

import org.eternity.exam.mapper.LectureMapper;
import org.eternity.exam.storage.LectureStorage;
import org.eternity.exam.type.FormatType;
import org.eternity.exam.type.StorageType;

import java.util.List;

public class LectureReporter {

    private final List<LectureMapper> mappers;
    private final List<LectureStorage> storages;

    public LectureReporter(List<LectureMapper> mappers, List<LectureStorage> storages) {
        this.mappers = mappers;
        this.storages = storages;
    }

    public void report(FormatType formatType, StorageType storageType, Lecture lecture) throws Exception {
        LectureMapper mapper = getMapper(formatType);
        if (mapper == null) {
            throw new IllegalArgumentException("지원하지 않는 포맷 타입입니다: " + formatType);
        }

        LectureStorage storage = getStorage(storageType);
        if (storage == null) {
            throw new IllegalArgumentException("지원하지 않는 저장소 타입입니다: " + storageType);
        }

        String serialized = mapper.writeValueAsString(lecture);
        storage.store(serialized);

    }

    private LectureMapper getMapper(FormatType formatType) {
        for (var mapper : mappers) {
            if (mapper.isSatisfied(formatType)) {
                return mapper;
            }
        }

        return null;
    }

    private LectureStorage getStorage(StorageType storageType) {
        for (var storage : storages) {
            if (storage.isSatisfied(storageType)) {
                return storage;
            }
        }

        return null;
    }
}
