package org.eternity.exam;

import org.eternity.exam.registry.LectureSerializerRegistry;
import org.eternity.exam.registry.LectureStorageRegistry;
import org.eternity.exam.serializer.FormatType;
import org.eternity.exam.storage.StorageType;
import org.springframework.stereotype.Service;

@Service
public class LectureReporter {
    private final LectureSerializerRegistry serializerRegistry;
    private final LectureStorageRegistry storageRegistry;

    public LectureReporter(LectureSerializerRegistry serializerRegistry,
                           LectureStorageRegistry storageRegistry) {
        this.serializerRegistry = serializerRegistry;
        this.storageRegistry = storageRegistry;
    }

    public void report(FormatType formatKey, StorageType storageKey, Lecture lecture) throws Exception {
        String serialized = serializerRegistry.get(formatKey).serialize(lecture);
        storageRegistry.get(storageKey).save(serialized);
    }
}
