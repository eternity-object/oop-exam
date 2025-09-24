package org.eternity.exam;

import org.eternity.exam.LectureReporter.StorageType;

public interface Reporter {

    void report(StorageType storageType) throws Exception;
}
