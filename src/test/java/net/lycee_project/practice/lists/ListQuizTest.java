package net.lycee_project.practice.lists;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import net.lycee_project.practice.QuizBase;
import net.lycee_project.practice.lists.ListQuiz;

public class ListQuizTest extends QuizBase {

	@Test
	public void test_search_max_value() {
		ListQuiz quiz = new ListQuiz();
		assertEquals("[TEST01]", Integer.valueOf(3), quiz.search_max_value(asList(1, 2, 3)));
		assertEquals("[TEST02]", Integer.valueOf(5), quiz.search_max_value(asList(1, 3, 5, 5, 3)));
		assertEquals("[TEST03]", Integer.valueOf(6), quiz.search_max_value(asList(6, 3, 3)));
		assertEquals("[TEST04]", Integer.valueOf(0), quiz.search_max_value(asList(0, 0, 0)));
		assertEquals("[TEST05]", Integer.valueOf(-3), quiz.search_max_value(asList(-1, -2, -3)));
		assertEquals("[TEST06]", Integer.valueOf(1), quiz.search_max_value(asList(1)));
	}

	@Test
	public void test_search_mode_value() {
		ListQuiz quiz = new ListQuiz();
		assertEquals("[TEST01]", Integer.valueOf(3), quiz.search_mode_value(asList(1, 2, 3)));
		assertEquals("[TEST02]", Integer.valueOf(5), quiz.search_mode_value(asList(1, 3, 5, 5, 3)));
		assertEquals("[TEST03]", Integer.valueOf(3), quiz.search_mode_value(asList(6, 3, 3)));
		assertEquals("[TEST04]", Integer.valueOf(0), quiz.search_mode_value(asList(0, 0, 0)));
		assertEquals("[TEST05]", Integer.valueOf(-1), quiz.search_mode_value(asList(-1, 0, -1, -1, -3)));
		assertEquals("[TEST06]", Integer.valueOf(1), quiz.search_mode_value(asList(1)));
		assertEquals("[TEST07]", Integer.valueOf(1), quiz.search_mode_value(asList(1, 1, 1, 2, 2, 2, 3, 3, 3)));
	}

	@Test
	public void test_search_longest_name() {
		ListQuiz quiz = new ListQuiz();
		assertEquals("[TEST01]", "Alice", quiz.search_longest_name(asList("Alice", "Bob")));
		assertEquals("[TEST02]", "Alice", quiz.search_longest_name(asList("Alice", "        Bob           ")));
		assertEquals("[TEST03]", "Charlie", quiz.search_longest_name(asList("Alice", "Bob", "Charlie")));
		assertEquals("[TEST04]", "Alice", quiz.search_longest_name(asList("Alice", "Bob", "Dave   ")));
		assertEquals("[TEST05]", "Alice", quiz.search_longest_name(asList("Alice", "Bob", "Ellen")));
		assertEquals("[TEST06]", "Alice", quiz.search_longest_name(asList(" Alice ", "Bob", "Ellen")));
		assertEquals("[TEST07]", "Charlie", quiz.search_longest_name(asList(" Alice ", "  Ellen", "Flank  ", "Charlie")));
		assertEquals("[TEST07]", "Alice", quiz.search_longest_name(asList("Alice")));
		assertEquals("[TEST07]", null, quiz.search_longest_name(asList()));
	}

	@Test
	public void test_crop_list() {
		ListQuiz quiz = new ListQuiz();
		assertEquals("[TEST01]", asList(1,2,3), quiz.crop_list(asList(1,2,3,4,5), 3));
		assertEquals("[TEST02]", asList(1), quiz.crop_list(asList(1,2,3,4,5), 1));
		assertEquals("[TEST03]", asList(1,2,3,4,5), quiz.crop_list(asList(1,2,3,4,5), 5));
		assertEquals("[TEST03]", asList(1,2,3,4,5), quiz.crop_list(asList(1,2,3,4,5), 6));
		assertEquals("[TEST04]", asList(1,2,3,4,5), quiz.crop_list(asList(1,2,3,4,5), 0));
		assertEquals("[TEST05]", asList(), quiz.crop_list(asList(), 1));
	}

	@Test
	public void test_remove_noise() {
		ListQuiz quiz = new ListQuiz();
		assertEquals("[TEST01]", asList("Alice"), quiz.remove_noise(asList("Alice", "Bob"), "Bob"));
		assertEquals("[TEST02]", asList("Alice"), quiz.remove_noise(asList("Alice", "Bob"), "B"));
		assertEquals("[TEST03]", asList("Bob"), quiz.remove_noise(asList("Alice", "Bob", "Charlie"), "i"));
		assertEquals("[TEST04]", asList(), quiz.remove_noise(asList("Alice", "Charlie", "Dave"), "e"));
		assertEquals("[TEST07]", asList("Flank"), quiz.remove_noise(asList(" Alice ", "Ellen", "Flank", "Charlie"), "e"));
		assertEquals("[TEST07]", asList(), quiz.remove_noise(asList("Alice"), "Alice"));
		assertEquals("[TEST07]", asList(), quiz.remove_noise(asList(), "Alice"));
	}

}
