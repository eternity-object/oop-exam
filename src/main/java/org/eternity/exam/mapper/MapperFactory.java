package org.eternity.exam.mapper;

import org.eternity.exam.type.FormatType;

public class MapperFactory {
    public static Mapper getMapper(FormatType formatType) {
        switch (formatType) {
            case JSON -> {
                return new JsonMapper();
            }
            case CSV -> {
                return new CsvMapper();
            }
            case XML -> {
                return new XmlMapper();
            }
            default -> {
                return null;
            }
        }
    }
}
