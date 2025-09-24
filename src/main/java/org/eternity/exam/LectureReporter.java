package org.eternity.exam;

import java.util.List;
import org.eternity.exam.save.SaveToStorage;
import org.eternity.exam.serializer.FormatSerializer;
import org.springframework.stereotype.Component;

@Component
public class LectureReporter {
    public enum FormatType { JSON, CSV, XML }
    public enum StorageType { DATABASE, FILE }

    private final List<FormatSerializer> formatSerializers;
    private final List<SaveToStorage> saveToStorages;

    public LectureReporter( List<FormatSerializer> formatSerializers,
            List<SaveToStorage> saveToStorages) {
        this.formatSerializers = formatSerializers;
        this.saveToStorages = saveToStorages;
    }

    public void report(FormatType formatType, StorageType storageType, Lecture lecture) {
        save(storageType, getSerialized(formatType, lecture));
    }

    private void save(StorageType storageType, String serialized) {
        saveToStorages.stream()
                .filter(storage -> storage.isSupport(storageType))
                .findFirst()
                .ifPresent(storage -> storage.save(serialized));
    }

    private String getSerialized(FormatType formatType, Lecture lecture) {
        return formatSerializers.stream()
                .filter(serializer -> serializer.isSupport(formatType))
                .findFirst()
                .map(serializer -> {
                    try {
                        return serializer.serialized(lecture);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .orElseThrow(() -> new IllegalArgumentException("지원되지 않는 포맷 타입입니다: " + formatType));
    }
}
