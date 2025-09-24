package org.eternity.exam;

import jdk.jfr.Registered;
import lombok.RequiredArgsConstructor;
import org.eternity.exam.formatconverter.FormatConverter;
import org.eternity.exam.storagewriter.StorageWriter;
import org.springframework.jdbc.core.simple.JdbcClient;

import java.io.FileWriter;

@RequiredArgsConstructor
public class LectureReporter {
    private final FormatConverter formatConverter;
    private final StorageWriter storageWriter;

    public void report(Lecture lecture) throws Exception {
        String serialized = formatConverter.convert(lecture);
        storageWriter.write(serialized);
    }
}
