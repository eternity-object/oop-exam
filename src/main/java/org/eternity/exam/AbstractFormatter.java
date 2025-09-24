package org.eternity.exam;

public abstract class AbstractFormatter implements Formatter {
    private final FormatType formatType;

    protected AbstractFormatter(FormatType formatType) {
        this.formatType = formatType;
    }
    public boolean supports(FormatType type) {
        return this.formatType == type;
    }

}
