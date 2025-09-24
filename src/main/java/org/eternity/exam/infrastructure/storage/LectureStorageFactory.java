package org.eternity.exam.infrastructure.storage;

import org.eternity.exam.common.StorageType;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class LectureStorageFactory {
    private final Map<StorageType, LectureStorage> storages;

    public LectureStorageFactory(
            DatabaseLectureStorage databaseStorage,
            FileLectureStorage fileStorage) {
        this.storages = Map.of(
            StorageType.DATABASE, databaseStorage,
            StorageType.FILE, fileStorage
        );
    }

    public LectureStorage getStorage(StorageType type) {
        LectureStorage storage = storages.get(type);
        if (storage == null) {
            throw new IllegalArgumentException("Unsupported storage type: " + type);
        }
        return storage;
    }
}