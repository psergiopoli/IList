package br.com.psergiopoli.ilist.model.Spotify;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Track {
	
	// JsonIgnore on Get to ignore on serialization for small json

	private Album album; 
	
	private List<Artist> artists;
	
	@JsonAlias("disc_number")
	private Integer discNumber;
	
	@JsonAlias("duration_ms")
	private Integer durationMs;
	
	private Boolean explicit;
	
	@JsonAlias("external_ids")
	private ExternalId externalIds;
	
	@JsonAlias("external_urls")
	private ExternalUrls externalUrls;
	
	private String href;
	
	private String id;
	
	@JsonAlias("is_playable")
	private Boolean isPlayable;
	
	private String name;
	
	private Integer popularity;
	
	@JsonAlias("preview_url")
	private String previewUrl;
	
	@JsonAlias("track_number")
	private Integer trackNumber;
	
	private String type;
	
	private String uri;

	@JsonIgnore()
	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	@JsonIgnore()
	public List<Artist> getArtists() {
		return artists;
	}

	public void setArtists(List<Artist> artists) {
		this.artists = artists;
	}

	@JsonIgnore()
	public Integer getDiscNumber() {
		return discNumber;
	}

	@JsonIgnore()
	public void setDiscNumber(Integer discNumber) {
		this.discNumber = discNumber;
	}

	@JsonIgnore()
	public Integer getDurationMs() {
		return durationMs;
	}

	public void setDurationMs(Integer durationMs) {
		this.durationMs = durationMs;
	}

	@JsonIgnore()
	public Boolean getExplicit() {
		return explicit;
	}

	public void setExplicit(Boolean explicit) {
		this.explicit = explicit;
	}

	@JsonIgnore()
	public ExternalId getExternalIds() {
		return externalIds;
	}

	public void setExternalIds(ExternalId externalIds) {
		this.externalIds = externalIds;
	}

	@JsonIgnore()
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

	@JsonIgnore()
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@JsonIgnore()
	public Boolean getIsPlayable() {
		return isPlayable;
	}

	public void setIsPlayable(Boolean isPlayable) {
		this.isPlayable = isPlayable;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonIgnore()
	public Integer getPopularity() {
		return popularity;
	}

	public void setPopularity(Integer popularity) {
		this.popularity = popularity;
	}

	@JsonIgnore()
	public String getPreviewUrl() {
		return previewUrl;
	}

	public void setPreviewUrl(String previewUrl) {
		this.previewUrl = previewUrl;
	}

	@JsonIgnore()
	public Integer getTrackNumber() {
		return trackNumber;
	}

	public void setTrackNumber(Integer trackNumber) {
		this.trackNumber = trackNumber;
	}

	@JsonIgnore()
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@JsonIgnore()
	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

}
