package org.eternity.exam;

import org.springframework.stereotype.Component;

@Component
public class LectureReporter {
    private final FormatterFactory formatterFactory;
    private final WriterFactory writerFactory;

    public LectureReporter(FormatterFactory formatterFactory, WriterFactory writerFactory) {
        this.formatterFactory = formatterFactory;
        this.writerFactory = writerFactory;
    }


    public void report(Lecture lecture, FormatType formatType, StorageType storageType)
        throws Exception {
        Formatter formatter = formatterFactory.createFormatter(formatType);
        Writer writer = writerFactory.createWriter(storageType);
        writer.write(formatter.formatToString(lecture));
    }
}
