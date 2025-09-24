package org.eternity.exam;

import org.eternity.exam.formatter.FormatterFactory;
import org.eternity.exam.writer.WriterFactory;

public class LectureReporter {
    public enum FormatType { JSON, CSV, XML }
    public enum StorageType { DATABASE, FILE }

    private final WriterFactory writerFactory;
    private final FormatterFactory formatterFactory;

    public LectureReporter(WriterFactory writerFactory, FormatterFactory formatterFactory) {
        this.writerFactory = writerFactory;
        this.formatterFactory = formatterFactory;
    }

    public void report(FormatType formatType, StorageType storageType, Lecture lecture) throws Exception {

        var serialized = formatterFactory.createReader(formatType).format(lecture);
        writerFactory.createWriter(storageType).write(serialized);
    }
}
