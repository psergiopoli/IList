package br.com.psergiopoli.ilist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.psergiopoli.ilist.model.Weather.WeatherInfo;
import br.com.psergiopoli.ilist.service.WeatherService;
import br.com.psergiopoli.ilist.util.TempUtil;

@RestController()
public class TrackListController {
	
	private WeatherService weatherService;
	
	@Autowired
	public TrackListController(WeatherService weatherService) {
		this.weatherService = weatherService;
	}
	
	// http://localhost:8080/Sao%20Carlos
	@RequestMapping(value = "/{cityName}", method = RequestMethod.GET)
	public ResponseEntity<Object> getTrackListByCityName(@PathVariable(value = "cityName") String cityName){
		WeatherInfo weatherInfo = this.weatherService.getWeather(cityName);
		Float temp = TempUtil.kelvinToCelsius(weatherInfo.getMain().getTemp());
		return new ResponseEntity<>(temp, HttpStatus.OK);
	}
	
	// http://localhost:8080/-22.02/-47.89
	@RequestMapping(value = "/{lat}/{lon}", method = RequestMethod.GET)
	public ResponseEntity<Object> getTrackListByLatLon(@PathVariable(value = "lat") Float lat, 
			@PathVariable(value = "lon") Float lon){
		WeatherInfo weatherInfo = this.weatherService.getWeather(lat, lon);
		Float temp = TempUtil.kelvinToCelsius(weatherInfo.getMain().getTemp());
		return new ResponseEntity<>(temp, HttpStatus.OK);
	}

}
