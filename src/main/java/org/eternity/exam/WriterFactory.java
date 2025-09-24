package org.eternity.exam;

import java.util.List;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Component;

@Component
public class WriterFactory {
    private final List<Writer> writers;

    public WriterFactory(List<Writer> writers) {
        this.writers = writers;
    }

    public Writer createWriter(StorageType storageType) {
        return writers.stream()
            .filter(writer -> writer.supports(storageType))
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);
    }
}
