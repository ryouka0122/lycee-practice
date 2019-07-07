package net.lycee_project.practice;


import java.util.ArrayList;
import java.util.List;

public class QuizBase {

	protected static <T> List<T> asList(T ...a) {
		List<T> list = new ArrayList<>();
		if (a!=null) {
			for (int i=0; i<a.length; i++) {
				list.add(a[i]);
			}
		}
		return list;
	}

}
