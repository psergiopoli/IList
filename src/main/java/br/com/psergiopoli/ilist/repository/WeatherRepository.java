package br.com.psergiopoli.ilist.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import br.com.psergiopoli.ilist.model.Weather.WeatherInfo;

@Repository
public class WeatherRepository {
	
    @Value("${openweathermapkey}")
    private String openWeatherKey;
    
    private RestTemplate restTemplate;
    
    Logger logger = LoggerFactory.getLogger(WeatherRepository.class);
	
	private static final String CITY_WEATHER_URL = "https://api.openweathermap.org/data/2.5/weather?q={1}&appid={2}";
	private static final String LAT_LON_WEATHER_URL = "https://api.openweathermap.org/data/2.5/weather?lat={1}&lon={2}&appid={3}";
	
	@Autowired
	public WeatherRepository(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public WeatherInfo findWeatherInfoByCityName(String cityName) {
		WeatherInfo weatherInfo = this.restTemplate.getForObject(CITY_WEATHER_URL, WeatherInfo.class, cityName, openWeatherKey);
		return weatherInfo;	
	}
	
	public WeatherInfo findWeatherInfoByLatLon(Float lat, Float lon) {
		WeatherInfo weatherInfo = this.restTemplate.getForObject(LAT_LON_WEATHER_URL, WeatherInfo.class, lat, lon, openWeatherKey);
		return weatherInfo;
	}
}
