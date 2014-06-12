package gao.zone.study.java8.lambdas.stream.album;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

public class Track {

	private final String name;
	private final int duration;

	public static Track genMockTrack() {
		int duration = RandomUtils.nextInt(50, 70);
		String name = RandomStringUtils.randomAlphabetic(duration % 5 + 3);
		return new Track(name, duration);
	}

	public Track(String name, int duration) {
		super();
		this.name = name;
		this.duration = duration;
	}

	public String getName() {
		return name;
	}

	public int getDuration() {
		return duration;
	}

	
	

}
