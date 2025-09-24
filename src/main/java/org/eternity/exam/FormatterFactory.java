package org.eternity.exam;

public class FormatterFactory {
    public static Formatter createFormatter(FormatType formatType) {
        switch (formatType) {
            case JSON:
                return new JsonFormatter();
            case CSV:
                return new CsvFormatter();
            case XML:
                return new XmlFormatter();
            default:
                throw new IllegalArgumentException();
        }
    }
}
