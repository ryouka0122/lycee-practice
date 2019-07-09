package net.lycee_project.practice.utils;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.Consumer;

public class RecordablePrintStreamHandler implements AutoCloseable {

	Consumer<String> recorder;

	PrintStream oldStream;
	RecordablePrintStream stream;

	public RecordablePrintStreamHandler(Consumer<String> recorder) {
		this.recorder = Objects.requireNonNull(recorder, "recorder must not be null.");
		stream = new RecordablePrintStream();
		oldStream = System.out;
		System.setOut(stream);
	}

	@Override
	public void close() throws Exception {
		System.setOut(oldStream);

		String[] array = stream.toStringArray();
		if (array!=null) {
			Arrays.stream(array).forEach(recorder);
		}
	}

}
