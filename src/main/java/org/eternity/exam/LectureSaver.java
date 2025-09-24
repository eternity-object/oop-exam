package org.eternity.exam;

import org.springframework.stereotype.Service;

@Service

public interface LectureSaver {
    void save(String serialized) throws Exception;
    boolean isType(StorageType type);
}
