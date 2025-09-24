package org.eternity.exam;

public class LectureReporter {
    private final Formatter formatter;
    private final Writer writer;

    public LectureReporter(Formatter formatter, Writer writer) {
        this.formatter = formatter;
        this.writer = writer;
    }

    public void report(Lecture lecture) throws Exception {
        writer.write(formatter.formatToString(lecture));
    }
}
