package org.eternity.exam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
@RequiredArgsConstructor
public class LectureReporter {


    private final List<LectureSaver> lectureSavers;
    private final List<LectureSerializer> lectureSerializer;

    public void report(FormatType formatType, StorageType storageType, Lecture lecture) {
        AtomicReference<String> serialized = new AtomicReference<>("");
        lectureSerializer.stream()
                .filter(serializer -> serializer.isType(formatType))
                .forEach(serializer ->{
                    try {
                        serialized.set(serializer.serialized(lecture));
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });


        lectureSavers.stream()
                .filter(lectureSaver -> lectureSaver.isType(storageType))
                .forEach(lectureSaver -> {
                    try {
                        lectureSaver.save(serialized.get());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
    }
}
