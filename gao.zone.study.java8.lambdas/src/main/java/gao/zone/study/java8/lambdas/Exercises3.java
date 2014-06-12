package gao.zone.study.java8.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Exercises3 {

	
	public static void main(String[] args) {
		
		List<String> words = Arrays.asList("hi", "hello", "world");
	
		words.stream().map(s->"  "+s).forEach(System.out::println);
		System.out.println();
		words.stream().forEach(System.out::println);
		System.out.println();
		
		words.stream().map(s->s.toUpperCase(Locale.US))
		.filter(s->s.length()<4)
		.filter(s->s.contains("e"))
		.findFirst();
		
	}
}
