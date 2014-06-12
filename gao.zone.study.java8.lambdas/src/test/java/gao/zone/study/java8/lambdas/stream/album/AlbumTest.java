package gao.zone.study.java8.lambdas.stream.album;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

public class AlbumTest {

	private List<Album> albums = new ArrayList<Album>();

	@Before
	public void init() {
		for (int i = 0; i < 10; i++) {
			albums.add(Album.genRandomAlbum());
		}
		albums.stream().forEach(a -> System.out.println(a));
	}

	@Test
	public void test() {
		Set<String> names = albums.stream().flatMap(a -> a.getTracks().stream()).filter(tr -> tr.getDuration() > 60)
				.map(tr -> tr.getName() + ":" + tr.getDuration()).collect(Collectors.toSet());
		System.out.println(names);

		albums.stream().forEach(a -> {
			IntSummaryStatistics sta = a.getTracks().stream().mapToInt(t -> t.getDuration()).summaryStatistics();
			System.out.printf("count=%d, max=%d, min=%d, sum=%d, avg=%.2f\n",sta.getCount(), sta.getMax(),sta.getMin(),sta.getSum(),sta.getAverage());
		});
	}
}
