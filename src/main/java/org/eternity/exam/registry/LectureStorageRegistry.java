package org.eternity.exam.registry;

import org.eternity.exam.storage.LectureStorage;
import org.eternity.exam.storage.StorageType;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class LectureStorageRegistry {
    private final Map<StorageType, LectureStorage> storages;

    public LectureStorageRegistry(List<LectureStorage> storageList) {
        this.storages = storageList.stream()
                .collect(Collectors.toMap(LectureStorage::key, s -> s));
    }

    public LectureStorage get(StorageType key) {
        var s = storages.get(key);
        if (s == null) throw new IllegalArgumentException("Unknown storage: " + key);
        return s;
    }
}
