package org.eternity.exam.registry;

import org.eternity.exam.serializer.FormatType;
import org.eternity.exam.serializer.LectureSerializer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class LectureSerializerRegistry {
    private final Map<FormatType, LectureSerializer> serializers;

    public LectureSerializerRegistry(List<LectureSerializer> serializerList) {
        this.serializers = serializerList.stream()
                .collect(Collectors.toMap(LectureSerializer::key, s -> s));
    }

    public LectureSerializer get(FormatType type) {
        var s = serializers.get(type);
        if (s == null) throw new IllegalArgumentException("Unknown serializer: " + type);
        return s;
    }
}
