package net.lycee_project.practice.utils;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class QuizTest extends QuizBase {

	@Test
	public void test_sample() {

		RecordablePrintStream rps = new RecordablePrintStream();
		PrintStream old = System.out;
		System.setOut(rps);

		System.out.println("aaa");
		System.out.println(123);
		System.out.println();
		System.out.println(111);
		System.out.println(3.14);
		System.out.println(123L);

		System.setOut(old);

		String[] array = rps.toStringArray();
		for(int i=0 ; i<array.length; i++) {
			System.out.println("★" + array[i]);
		}

	}

	@Test
	public void test_sample2() throws Exception {

		List<String> record = new ArrayList<>();

		try(RecordablePrintStreamHandler handler = new RecordablePrintStreamHandler(record::add)) {
			System.out.println("aaa");
			System.out.println(123);
			System.out.println();
			System.out.println(111);
			System.out.println(3.14);
			System.out.println(123L);
		}

		for(int i=0 ; i<record.size(); i++) {
			System.out.println("★" + record.get(i));
		}


	}



}
