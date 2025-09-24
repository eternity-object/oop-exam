package org.eternity.exam;

public abstract class AbstractFormatter implements Formatter {
    private FormatType formatType;

    protected AbstractFormatter(FormatType formatType) {
        this.formatType = formatType;
    }
}
