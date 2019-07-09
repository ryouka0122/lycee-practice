package net.lycee_project.practice.lists;

import org.junit.Test;

import net.lycee_project.practice.utils.QuizBase;

public class ListQuizTest extends QuizBase {

	@Test
	public void test_search_max_value() {
		ListQuiz quiz = new ListQuiz();
		returnValueTest("[TEST01]", Integer.valueOf(3), () -> quiz.search_max_value(asList(1, 2, 3)));
		returnValueTest("[TEST02]", Integer.valueOf(5), () -> quiz.search_max_value(asList(1, 3, 5, 5, 3)));
		returnValueTest("[TEST03]", Integer.valueOf(6), () -> quiz.search_max_value(asList(6, 3, 3)));
		returnValueTest("[TEST04]", Integer.valueOf(0), () -> quiz.search_max_value(asList(0, 0, 0)));
		returnValueTest("[TEST05]", Integer.valueOf(-3), () -> quiz.search_max_value(asList(-1, -2, -3)));
		returnValueTest("[TEST06]", Integer.valueOf(1), () -> quiz.search_max_value(asList(1)));
	}

	@Test
	public void test_search_mode_value() {
		ListQuiz quiz = new ListQuiz();
		returnValueTest("[TEST01]", Integer.valueOf(3), () -> quiz.search_mode_value(asList(1, 2, 3)));
		returnValueTest("[TEST02]", Integer.valueOf(5), () -> quiz.search_mode_value(asList(1, 3, 5, 5, 3)));
		returnValueTest("[TEST03]", Integer.valueOf(3), () -> quiz.search_mode_value(asList(6, 3, 3)));
		returnValueTest("[TEST04]", Integer.valueOf(0), () -> quiz.search_mode_value(asList(0, 0, 0)));
		returnValueTest("[TEST05]", Integer.valueOf(-1), () -> quiz.search_mode_value(asList(-1, 0, -1, -1, -3)));
		returnValueTest("[TEST06]", Integer.valueOf(1), () -> quiz.search_mode_value(asList(1)));
		returnValueTest("[TEST07]", Integer.valueOf(1), () -> quiz.search_mode_value(asList(1, 1, 1, 2, 2, 2, 3, 3, 3)));
	}

	@Test
	public void test_search_longest_name() {
		ListQuiz quiz = new ListQuiz();
		returnValueTest("[TEST01]", "Alice", () -> quiz.search_longest_name(asList("Alice", "Bob")));
		returnValueTest("[TEST02]", "Alice", () -> quiz.search_longest_name(asList("Alice", "        Bob           ")));
		returnValueTest("[TEST03]", "Charlie", () -> quiz.search_longest_name(asList("Alice", "Bob", "Charlie")));
		returnValueTest("[TEST04]", "Alice", () -> quiz.search_longest_name(asList("Alice", "Bob", "Dave   ")));
		returnValueTest("[TEST05]", "Alice", () -> quiz.search_longest_name(asList("Alice", "Bob", "Ellen")));
		returnValueTest("[TEST06]", "Alice", () -> quiz.search_longest_name(asList(" Alice ", "Bob", "Ellen")));
		returnValueTest("[TEST07]", "Charlie", () -> quiz.search_longest_name(asList(" Alice ", "  Ellen", "Flank  ", "Charlie")));
		returnValueTest("[TEST07]", "Alice", () -> quiz.search_longest_name(asList("Alice")));
		returnValueTest("[TEST07]", null, () -> quiz.search_longest_name(asList()));
	}

	@Test
	public void test_crop_list() {
		ListQuiz quiz = new ListQuiz();
		returnValueTest("[TEST01]", asList(1,2,3), () -> quiz.crop_list(asList(1,2,3,4,5), 3));
		returnValueTest("[TEST02]", asList(1), () -> quiz.crop_list(asList(1,2,3,4,5), 1));
		returnValueTest("[TEST03]", asList(1,2,3,4,5), () -> quiz.crop_list(asList(1,2,3,4,5), 5));
		returnValueTest("[TEST03]", asList(1,2,3,4,5), () -> quiz.crop_list(asList(1,2,3,4,5), 6));
		returnValueTest("[TEST04]", asList(1,2,3,4,5), () -> quiz.crop_list(asList(1,2,3,4,5), 0));
		returnValueTest("[TEST05]", asList(), () -> quiz.crop_list(asList(), 1));
	}

	@Test
	public void test_remove_noise() {
		ListQuiz quiz = new ListQuiz();
		returnValueTest("[TEST01]", asList("Alice"), () -> quiz.remove_noise(asList("Alice", "Bob"), "Bob"));
		returnValueTest("[TEST02]", asList("Alice"), () -> quiz.remove_noise(asList("Alice", "Bob"), "B"));
		returnValueTest("[TEST03]", asList("Bob"), () -> quiz.remove_noise(asList("Alice", "Bob", "Charlie"), "i"));
		returnValueTest("[TEST04]", asList(), () -> quiz.remove_noise(asList("Alice", "Charlie", "Dave"), "e"));
		returnValueTest("[TEST07]", asList("Flank"), () -> quiz.remove_noise(asList(" Alice ", "Ellen", "Flank", "Charlie"), "e"));
		returnValueTest("[TEST07]", asList(), () -> quiz.remove_noise(asList("Alice"), "Alice"));
		returnValueTest("[TEST07]", asList(), () -> quiz.remove_noise(asList(), "Alice"));
	}

}
