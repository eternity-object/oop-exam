package org.eternity.exam;

import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.EnumMap;
import java.util.Map;

@Component
public class LectureReporter {
    public enum FormatType { JSON, CSV, XML }
    public enum StorageType { DATABASE, FILE }

    interface Formatter { String format(Lecture l); }
    interface Saver { void save(String s); }

    private static final DateTimeFormatter ISO = DateTimeFormatter.ISO_LOCAL_DATE;

    private final Map<FormatType, Formatter> formatters = new EnumMap<>(FormatType.class);
    private final Map<StorageType, Saver> savers = new EnumMap<>(StorageType.class);

    public LectureReporter() {
        // JSON: 공백/줄바꿈 없이, 키 순서 고정(title,date,days)
        formatters.put(FormatType.JSON, l ->
                "{\"title\":\"" + l.getTitle() + "\",\"date\":\"" + ISO.format(l.getDate()) + "\",\"days\":" + l.getDays() + "}"
        );
        // CSV: 헤더 고정, 쉼표 구분, 날짜 ISO
        formatters.put(FormatType.CSV, l ->
                "title,date,days\n" + l.getTitle() + "," + ISO.format(l.getDate()) + "," + l.getDays()
        );
        // XML: 한 줄, 불필요한 공백/개행 없음, 태그 순서 고정
        formatters.put(FormatType.XML, l ->
                "<lecture><title>" + l.getTitle() + "</title><date>" + ISO.format(l.getDate()) + "</date><days>" + l.getDays() + "</days></lecture>"
        );

        // 저장은 과제 채점용으로 콘솔 로그만 (형식: [DATABASE] 또는 [FILE] + 공백 + 본문 한 줄)
        savers.put(StorageType.DATABASE, s -> System.out.println("[DATABASE] " + s));
        savers.put(StorageType.FILE,     s -> System.out.println("[FILE] " + s));
    }

    public void report(FormatType formatType, StorageType storageType, Lecture lecture) {
        try {
            String serialized = formatters.get(formatType).format(lecture);
            savers.get(storageType).save(serialized);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
