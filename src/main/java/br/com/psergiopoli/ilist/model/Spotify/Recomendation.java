package br.com.psergiopoli.ilist.model.Spotify;

import java.util.List;

public class Recomendation {
	
	List<Track> tracks;
	
	List<Seed> seeds;

	public List<Track> getTracks() {
		return tracks;
	}

	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}

	public List<Seed> getSeeds() {
		return seeds;
	}

	public void setSeeds(List<Seed> seeds) {
		this.seeds = seeds;
	}
	
}
