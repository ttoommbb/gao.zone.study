package gao.zone.study.java8.lambdas;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.groupingByConcurrent;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toCollection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import org.junit.Test;

public class LambdasExpTest2 {

	@Test
	public void test() {
		List<Integer> numbers = asList(4, 3, 2, 1);
		List<Integer> sorted = numbers.stream().sorted().collect(Collectors.toList());
		System.out.println(Arrays.toString(numbers.toArray()));
		System.out.println(Arrays.toString(sorted.toArray()));
	}

	@Test
	public void otherTest() {
		List<Integer> numbers = asList(4, 3, 2, 1);
		TreeSet<Integer> collect = numbers.stream().collect(toCollection(TreeSet::new));
	}

	@Test
	public void maxBy() {
		List<Integer> numbers = asList(4, 3, 2, 1, 5, 6, 7, 8, -1, -3, -5, -7, -10);
		Optional<Integer> collect = numbers.stream().collect(Collectors.maxBy(Comparator.comparing(x -> x * x)));
		System.out.println(collect.get());
	}

	@Test
	public void partition() {
		List<Integer> numbers = asList(4, 3, 2, 1, 5, 6, 7, 8, -1, -3, -5, -7, -10);
		Map<Boolean, List<Integer>> collect = numbers.parallelStream().collect(partitioningBy(x -> x % 2 == 0));
		collect.forEach((k, v) -> {
			System.out.println("key:"+k);
			System.out.println("value:"+Arrays.toString(v.toArray()));
		});
	}
	
	
	@Test
	public void grouping() {
		System.out.println("LambdasExpTest2.grouping()");
		List<Integer> numbers = asList(4, 3, 2, 1, 5, 6, 7, 8, -1, -3, -5, -7, -10);
		ConcurrentMap<Object, List<Integer>> collect = numbers.parallelStream().collect(groupingByConcurrent(x->x%3));
		collect.forEach((k, v) -> {
			System.out.println("key:"+k);
			System.out.println("value:"+Arrays.toString(v.toArray()));
		});
	}
	
	
}
