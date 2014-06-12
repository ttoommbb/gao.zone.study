package gao.zone.study.java8.lambdas;

import java.util.Arrays;

import org.junit.Test;

public class ArrayTest {

	@Test
	public void test() {
		int[] nums = new int[1000];
		Arrays.parallelSetAll(nums, i->i);
		System.out.println();
	}
}
