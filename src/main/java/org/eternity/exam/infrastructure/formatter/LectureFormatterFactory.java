package org.eternity.exam.infrastructure.formatter;

import org.eternity.exam.common.FormatType;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class LectureFormatterFactory {
    private final Map<FormatType, LectureFormatter> formatters;

    public LectureFormatterFactory(
            JsonLectureFormatter jsonFormatter,
            CsvLectureFormatter csvFormatter,
            XmlLectureFormatter xmlFormatter) {
        this.formatters = Map.of(
            FormatType.JSON, jsonFormatter,
            FormatType.CSV, csvFormatter,
            FormatType.XML, xmlFormatter
        );
    }

    public LectureFormatter getFormatter(FormatType type) {
        LectureFormatter formatter = formatters.get(type);
        if (formatter == null) {
            throw new IllegalArgumentException("Unsupported format type: " + type);
        }
        return formatter;
    }
}