package net.lycee_project.practice.utils;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class RecordablePrintStream extends PrintStream {

	private static int INITIAL_BUFFERED_SIZE = 1024;

	public RecordablePrintStream() {
		this(INITIAL_BUFFERED_SIZE);
	}

	public RecordablePrintStream(int capacity) {
		super(new ByteArrayOutputStream(capacity));
	}

	public String[] toStringArray() {
		ByteArrayOutputStream baos = (ByteArrayOutputStream) out;
		return new String(baos.toByteArray()).split("\r\n");
	}
}
