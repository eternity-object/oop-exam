package org.eternity.exam.storage;

import java.io.IOException;

public interface Storage {
	void save(String serialized) throws IOException;
}
