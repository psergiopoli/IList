package br.com.psergiopoli.ilist.model.Weather;

public class Sys {
	
	private Float message;
	private String country;
	private Integer sunrise;
	private Integer sunset;

	public Float getMessage() {
		return message;
	}
	public void setMessage(Float message) {
		this.message = message;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Integer getSunrise() {
		return sunrise;
	}
	public void setSunrise(Integer sunrise) {
		this.sunrise = sunrise;
	}
	public Integer getSunset() {
		return sunset;
	}
	public void setSunset(Integer sunset) {
		this.sunset = sunset;
	}

}
