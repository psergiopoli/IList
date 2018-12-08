package br.com.psergiopoli.ilist.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import br.com.psergiopoli.ilist.exceptions.CityNotFoundException;
import br.com.psergiopoli.ilist.exceptions.IListExpcetion;
import br.com.psergiopoli.ilist.model.Weather.WeatherInfo;
import br.com.psergiopoli.ilist.repository.WeatherRepository;

@Service
public class WeatherService {
	
	private WeatherRepository weatherRepository;
	
	Logger logger = LoggerFactory.getLogger(WeatherService.class);
	
	@Autowired
	public WeatherService(WeatherRepository weatherRepository) {
		this.weatherRepository = weatherRepository;
	}

	public WeatherInfo getWeather(String cityName) {
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
	
	public WeatherInfo getWeather(Float lat, Float lon) {
		try {
			return this.weatherRepository.findWeatherInfoByLatLon(lat, lon);
		} catch (HttpClientErrorException e) {
			logger.error(e.getMessage(), e);
			throw new IListExpcetion("Erro ao buscar temperatura", e.getStatusCode());
		}
	}
	
}
