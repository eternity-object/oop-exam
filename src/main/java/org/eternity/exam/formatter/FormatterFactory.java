package org.eternity.exam.formatter;

import org.eternity.exam.LectureReporter;

public class FormatterFactory {
    public Formatter createReader(LectureReporter.FormatType formatType) {
        return switch (formatType) {
            case JSON -> new JsonFormatter();
            case CSV -> new CsvFormatter();
            case XML -> new XmlFormatter();
        };
    }
}
