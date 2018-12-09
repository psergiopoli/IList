package br.com.psergiopoli.ilist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.psergiopoli.ilist.model.Spotify.Track;
import br.com.psergiopoli.ilist.service.TrackListService;

@RestController()
@RequestMapping("ilist")
public class TrackListController {
	
	private TrackListService trackListService;
	
	@Autowired
	public TrackListController(TrackListService trackListService) {
		this.trackListService = trackListService;
	}
	
	// http://localhost:8080/ilist/Sao%20Carlos
	@RequestMapping(value = "/{cityName}", method = RequestMethod.GET)
	public ResponseEntity<List<Track>> getTrackListByCityName(@PathVariable(value = "cityName") String cityName){
		List<Track> tracks = this.trackListService.getTrackList(cityName);
		return new ResponseEntity<>(tracks, HttpStatus.OK);
	}
	
	// http://localhost:8080/ilist/-22.02/-47.89
	@RequestMapping(value = "/{lat}/{lon}", method = RequestMethod.GET)
	public ResponseEntity<List<Track>> getTrackListByLatLon(@PathVariable(value = "lat") Float lat, @PathVariable(value = "lon") Float lon){
		List<Track> tracks = this.trackListService.getTrackList(lat, lon);
		return new ResponseEntity<>(tracks, HttpStatus.OK);
	}

}
