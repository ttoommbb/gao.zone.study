package gao.zone.study.java8.lambdas;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Exercises2 {

	public static <T> List<T> allMatches(List<T> list, Predicate<T> predicate) {
		return list.stream().filter(predicate).collect(toList());

	}

	public static void main(String[] args) {
		List<String> list = Arrays.asList("a", "bb", "ccc", "dddd", "eeeee");
		System.out.println(list);
		list = allMatches(list, s -> s.length() < 4);
		System.out.println(list);

		System.out.println();
		list = Arrays.asList("a", "bb", "ccc", "dddd", "eeeee");
		System.out.println(list);
		list = allMatches(list, s -> s.contains("b"));
		System.out.println(list);

		System.out.println();
		list = Arrays.asList("a", "bb", "ccc", "dddd", "eeeee");
		System.out.println(list);
		list = allMatches(list, s -> s.length() % 2 == 0);
		System.out.println(list);

		System.out.println();
		list = Arrays.asList("a", "bb", "ccc", "dddd", "eeeee");
		System.out.println(list);
		list = transformedList(list, s -> s + "!");
		System.out.println(list);

		System.out.println();
		list = Arrays.asList("a", "bb", "ccc", "dddd", "eeeee","iiiiiii");
		System.out.println(list);
		list = transformedList(list, s -> s.replace("i", "eye"));
		System.out.println(list);

		System.out.println();
		list = Arrays.asList("a", "bb", "ccc", "dddd", "eeeee");
		System.out.println(list);
		list = transformedList(list, String::toUpperCase);
		System.out.println(list);

	}

	public static <T> List<T> transformedList(List<T> list, Function<T, T> function) {
		return list.stream().map(function).collect(toList());
	}
}
