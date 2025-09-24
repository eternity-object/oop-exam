package org.eternity.exam.storage;

import org.springframework.jdbc.core.simple.JdbcClient;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JdbcStorage implements Storage {

	private final JdbcClient jdbcClient;

	@Override
	public void save(String serialized) {

	}
}
