package br.com.psergiopoli.ilist.util;

public class TempUtil {

	public static Float kelvinToCelsius(Float kelvin) {
		return kelvin - 273.15F;
	}
	
	public static Genre getGenreByTemp(Float kelvin) {
		Float celcius = kelvinToCelsius(kelvin);
		
		if (celcius >= 30) {
			return Genre.PARTY;
		} else if (celcius < 30 && celcius >= 15) {
			return Genre.POP;
		} else if (celcius < 15 && celcius >= 10) {
			return Genre.ROCK;
		} else if (celcius < 10) {
			return Genre.CLASSICAL;
		}
		
		return null;
	}
	
}
