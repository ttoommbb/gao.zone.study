package gao.zone.study.java8.lambdas.optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import java.util.Optional;

import org.junit.Test;

public class OptionalTest {

	@Test
	public void test() {
		Optional<String> optional = Optional.empty();
		assertFalse(optional.isPresent());
		Optional<?> nullable = Optional.ofNullable(null);
		assertFalse(nullable.isPresent());
		
		assertEquals("c",optional.orElseGet(()->"c"));
	}
}
