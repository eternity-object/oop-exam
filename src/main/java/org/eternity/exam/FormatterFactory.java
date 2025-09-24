package org.eternity.exam;

import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class FormatterFactory {
    private final List<Formatter> formatters;

    public FormatterFactory(List<Formatter> formatters) {
        this.formatters = formatters;
    }

    public Formatter createFormatter(FormatType formatType) {
        return formatters.stream()
            .filter(formatter -> formatter.supports(formatType))
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);
    }
}
