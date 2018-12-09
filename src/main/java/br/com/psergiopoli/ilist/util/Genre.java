package br.com.psergiopoli.ilist.util;

public enum Genre {
	PARTY("party"),
	POP("pop"),
	ROCK("rock"),
	CLASSICAL("classical");
	
	public String genreName;
	
	Genre(String genreName) {
		this.genreName = genreName;
	}
}
