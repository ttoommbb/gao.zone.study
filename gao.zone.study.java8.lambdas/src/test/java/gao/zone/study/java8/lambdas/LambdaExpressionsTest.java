package gao.zone.study.java8.lambdas;

import java.awt.Checkbox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

import javax.swing.text.DateFormatter;

import org.junit.Test;

public class LambdaExpressionsTest {

	@Test
	public void simpleLambdasTest() throws InterruptedException {
		Runnable noArgs = () -> System.out.println("hello world");
		noArgs.run();

		ActionListener oneArg = event -> System.out.println("hello:" + event);

		oneArg.actionPerformed(new ActionEvent("event source", 1, null));

		BinaryOperator<Long> add = (x, y) -> {
			System.out.println("x+y=" + (x + y));
			return x + y;
		};
		System.out.println(add.apply(1L, 2L));

		BiPredicate<Long, Integer> predicate = (Long l, Integer i) -> l.intValue() == i;
		System.out.println(predicate.test(5L, 5));

		BiFunction<Long, Integer, Boolean> biFunction = (l, i) -> (l.intValue() == i.intValue());
		System.out.println(biFunction.apply(5L, 5));

		Function<Long, Long> incFunction = (l) -> ++l;
		System.out.println("inc100:" + incFunction.apply(100L));

		ThreadLocal<Long> randomLong = ThreadLocal.withInitial(() -> new Random().nextLong());
		System.out.println("randomLong:" + randomLong.get());
		System.out.println("randomLong:" + randomLong.get());
		Executors.newSingleThreadExecutor().execute(() -> System.out.println("randomLong:" + randomLong.get()));
		Executors.newSingleThreadExecutor().execute(() -> System.out.println("randomLong:" + randomLong.get()));
		Thread.sleep(100);
		System.out.println("randomLong:" + randomLong.get());
	}

	@Test
	public void safeDateFormatterTest() {
		ThreadLocal<DateFormatter> threadLocal = ThreadLocal.withInitial(() -> new DateFormatter());

		String formatted = threadLocal.get().getFormat().format(new Date());
		System.out.println(formatted);
	}
	
	
	static interface IntPred{
		boolean test(Integer value);
	}
	
	@Test
	public void intPredTest() {
		boolean rst = ((Function<Integer,Boolean>)x->x>5).apply(4);
		System.out.println(rst);
		
		check(x->x>5);
		//remove either check method below to fix.
	}
	
//	private final static boolean check(Predicate<Integer> predicate) {
//		return predicate.test(5);
//	}
	private final static boolean check(IntPred predicate) {
		return predicate.test(5);
	}

	
	@Test
	public void simpleLambdasTest2() {

	}
}
