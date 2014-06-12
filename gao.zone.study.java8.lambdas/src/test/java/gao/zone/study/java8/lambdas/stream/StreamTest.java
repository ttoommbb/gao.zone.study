package gao.zone.study.java8.lambdas.stream;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.junit.Test;

public class StreamTest {

	@Test
	public void test() {
		List<Point> points = new ArrayList<Point>();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				points.add(new Point(i, j));
			}
		}

		points.stream().filter(p -> p.x == p.y).forEach(p -> System.out.println(p));

		Set<Integer> set = points.stream().map(p -> p.x + p.y).collect(Collectors.toSet());
		System.out.println(set);

		List<String> collect = Stream.of("a", "b", "c").collect(Collectors.toList());

		// Object[] array = points.stream().toArray(i->System.out.println(i));
		Integer sum = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).parallel().reduce(0, (ac, el) -> {
			int temp = ac + el;
			System.out.println(ac + "+" + el + "=" + temp);
			return temp;
		});
		System.out.println(sum);
	}
	
	@Test
	public void tsetNums() {
		int[] nums= {1,2,3,4,5};
		System.out.println(Arrays.toString(nums));
		nums = Arrays.stream(nums).parallel().flatMap(i->IntStream.of(i,i*i,i*i*i))
		.toArray();
		System.out.println(Arrays.toString(nums));
		
	}
	
	@Test
	public void testMethod() {
		Stream.of(1,2,3,4,5).forEach(System.out::println);
		 List<String> list = Stream.of(1,2,3,4,5).map(n->n.toString()).collect(Collectors.toList());
		System.out.println(String.join(",",list));
	}
	
	@Test
	public void testJoining() {
		int[] nums = new int[10000];
		for (int j = 0; j < nums.length; j++) {
			nums[j]= j;
		}
		
		IntStream parallel = Arrays.stream(nums).parallel();
		String collect = parallel.mapToObj(i->String.valueOf(i)).collect(Collectors.joining(", "));
		System.out.println(collect);
		
	}
}
