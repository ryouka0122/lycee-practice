package net.lycee_project.practice.utils;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class QuizBase {

	@SafeVarargs
	protected static <T> List<T> asList(T ...a) {
		List<T> list = new ArrayList<>();
		if (a!=null) {
			for (int i=0; i<a.length; i++) {
				list.add(a[i]);
			}
		}
		return list;
	}


	protected <T> void returnValueTest(
			String name,
			T expected,
			Supplier<T> examinator
			) {
		assertEquals(name, expected, examinator.get());
	}


	protected void sysoutTest(
			String name,
			List<String> expected,
			Runnable examinator
			) {
		List<String> list = new ArrayList<>();
		try (RecordablePrintStreamHandler handler = new RecordablePrintStreamHandler(list::add)) {
			examinator.run();
		} catch (Exception e) {
			fail(e.getMessage());
		}

		assertListEquals(name, expected, list);

	}

	private static <T> void assertListEquals(String message, List<T> expected, List<T> actual) {
		if (expected==actual) {
			return;
		}
		assertEquals(message + "/size", expected.size(), actual.size());

		for(int index=0, len= expected.size(); index<len ; index++) {
			assertEquals(message + "["+index+"]", expected.get(index),actual.get(index));
		}
	}
}
