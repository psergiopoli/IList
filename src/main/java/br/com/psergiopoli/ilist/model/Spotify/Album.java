package br.com.psergiopoli.ilist.model.Spotify;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;

public class Album {
	
	@JsonAlias("album_type")
	private String albumType;
	
	private List<Artist> artists;
	
	@JsonAlias("external_urls")
	private ExternalUrls externalUrls;
	
	private String href;
	
	private String id;
	
	private List<Image> images;
	
	private String name;
	
	private String type;
	
	private String uri;

	public String getAlbumType() {
		return albumType;
	}

	public void setAlbumType(String albumType) {
		this.albumType = albumType;
	}

	public List<Artist> getArtists() {
		return artists;
	}

	public void setArtists(List<Artist> artists) {
		this.artists = artists;
	}

	public ExternalUrls getExternalUrls() {
		return externalUrls;
	}

	public void setExternalUrls(ExternalUrls externalUrls) {
		this.externalUrls = externalUrls;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

}
