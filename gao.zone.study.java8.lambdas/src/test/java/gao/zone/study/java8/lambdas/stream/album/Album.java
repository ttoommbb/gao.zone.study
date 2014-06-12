package gao.zone.study.java8.lambdas.stream.album;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.RandomUtils;

public class Album {

	private List<Track> tracks;
	
	public List<Track> getTracks() {
		return Collections.unmodifiableList(tracks);
	}

	public Album() {
		tracks = new ArrayList<Track>();
	}

	public static Album genRandomAlbum() {
		Album album= new Album();
		int counts = RandomUtils.nextInt(4, 10);
		for (int i = 0; i < counts; i++) {
			album.addTrack(Track.genMockTrack());
		}
		return album;
	}

	private void addTrack(Track track) {
		tracks.add(track);
	}

	@Override
	public String toString() {
		String tracksString = tracks.stream().parallel().map(t->t.getName()+":"+t.getDuration())
		.reduce((t1,t2)->t1+", "+t2).orElse("");
		
		return "Album [tracks=" +tracksString+ "]";
	}
	
	
}
