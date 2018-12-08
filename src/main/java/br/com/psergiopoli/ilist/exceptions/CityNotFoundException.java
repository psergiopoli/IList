package br.com.psergiopoli.ilist.exceptions;

import org.springframework.http.HttpStatus;

public class CityNotFoundException extends IListExpcetion {

	private static final long serialVersionUID = 1L;

	public CityNotFoundException(String message) {
		super(message, HttpStatus.NOT_FOUND);
	}
	
}
