package org.eternity.exam;

import com.fasterxml.jackson.core.JsonProcessingException;

public abstract class Recoder {

    private final Converter converter;

    protected Recoder(Converter converter) {
        this.converter = converter;
    }

    public void record(Lecture lecture) throws JsonProcessingException {
        String serialized = converter.convert(lecture);

        save(serialized);
    }

    protected abstract void save(String serialized);
}
