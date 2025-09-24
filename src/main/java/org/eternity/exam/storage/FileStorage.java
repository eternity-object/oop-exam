package org.eternity.exam.storage;

import java.io.FileWriter;
import java.io.IOException;

public class FileStorage implements Storage {

	private final FileWriter writer;

	public FileStorage(String fileName) throws IOException {
		this.writer = new FileWriter(fileName);
	}

	@Override
	public void save(String serialized) throws IOException {
		writer.write(serialized);
		writer.flush();
	}
}
