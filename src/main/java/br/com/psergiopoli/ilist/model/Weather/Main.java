package br.com.psergiopoli.ilist.model.Weather;

import com.fasterxml.jackson.annotation.JsonAlias;

public class Main {
	
	private Float temp;
	private Float pressure;
	private Integer umidity;
	
	@JsonAlias("temp_min")
	private Float tempMin;
	
	@JsonAlias("temp_max")
	private Float tempMax;
	
	@JsonAlias("sea_level")
	private Float seaLevel;
	
	@JsonAlias("grnd_level")
	private Float grndLevel;

	public Float getTemp() {
		return temp;
	}

	public void setTemp(Float temp) {
		this.temp = temp;
	}

	public Float getPressure() {
		return pressure;
	}

	public void setPressure(Float pressure) {
		this.pressure = pressure;
	}

	public Integer getUmidity() {
		return umidity;
	}

	public void setUmidity(Integer umidity) {
		this.umidity = umidity;
	}

	public Float getTempMin() {
		return tempMin;
	}

	public void setTempMin(Float tempMin) {
		this.tempMin = tempMin;
	}

	public Float getTempMax() {
		return tempMax;
	}

	public void setTempMax(Float tempMax) {
		this.tempMax = tempMax;
	}

	public Float getSeaLevel() {
		return seaLevel;
	}

	public void setSeaLevel(Float seaLevel) {
		this.seaLevel = seaLevel;
	}

	public Float getGrndLevel() {
		return grndLevel;
	}

	public void setGrndLevel(Float grndLevel) {
		this.grndLevel = grndLevel;
	}

}
