package org.eternity.exam;

public interface Formatter {
    String formatToString(Lecture lecture) throws Exception;
    boolean supports(FormatType formatType);
}

