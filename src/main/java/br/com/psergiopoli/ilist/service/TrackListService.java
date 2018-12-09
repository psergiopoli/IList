package br.com.psergiopoli.ilist.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import br.com.psergiopoli.ilist.exceptions.CityNotFoundException;
import br.com.psergiopoli.ilist.exceptions.IListExpcetion;
import br.com.psergiopoli.ilist.model.Spotify.Track;
import br.com.psergiopoli.ilist.model.Weather.WeatherInfo;
import br.com.psergiopoli.ilist.repository.RecomendationRepository;
import br.com.psergiopoli.ilist.repository.WeatherRepository;
import br.com.psergiopoli.ilist.util.Genre;
import br.com.psergiopoli.ilist.util.TempUtil;

@Service
public class TrackListService {
	
	private WeatherRepository weatherRepository;
	
	private RecomendationRepository recomendationRepository;
	
	Logger logger = LoggerFactory.getLogger(TrackListService.class);
	
	@Autowired
	public TrackListService(WeatherRepository weatherRepository,
			RecomendationRepository recomendationRepository
			) {
		this.weatherRepository = weatherRepository;
		this.recomendationRepository = recomendationRepository;
	}
	
	public List<Track> getTrackList(String cityName) {
		WeatherInfo weatherInfo = getWeather(cityName);
		Genre genre = TempUtil.getGenreByTemp(weatherInfo.getMain().getTemp());
		return this.recomendationRepository.getRecomendationListByGenre(genre).getTracks();
	}
	
	public List<Track> getTrackList(Float lat, Float lon) {
		WeatherInfo weatherInfo = getWeather(lat, lon);
		Genre genre = TempUtil.getGenreByTemp(weatherInfo.getMain().getTemp());
		return this.recomendationRepository.getRecomendationListByGenre(genre).getTracks();
	}

	private WeatherInfo getWeather(String cityName) {
		try {
			return this.weatherRepository.findWeatherInfoByCityName(cityName);
		} catch (HttpClientErrorException e) {
			logger.error(e.getMessage(), e);
			if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
				throw new CityNotFoundException("Cidade nao encontrada");
			}
			throw new IListExpcetion("Erro ao buscar temperatura", e.getStatusCode());
			// Formato do retorno do erro da api de temperatura e, {cod: cod, message:message}, poderia retornar o erro da api direto
		}
	}
	
	private WeatherInfo getWeather(Float lat, Float lon) {
		try {
			return this.weatherRepository.findWeatherInfoByLatLon(lat, lon);
		} catch (HttpClientErrorException e) {
			logger.error(e.getMessage(), e);
			throw new IListExpcetion("Erro ao buscar temperatura", e.getStatusCode());
		}
	}
	
}
