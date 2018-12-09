package br.com.psergiopoli.ilist.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import br.com.psergiopoli.ilist.SpotifyLogin;
import br.com.psergiopoli.ilist.model.Spotify.Recomendation;
import br.com.psergiopoli.ilist.util.Genre;

@Repository
public class RecomendationRepository {
	
	private static final String RECOMENDATION_URL = "https://api.spotify.com/v1/recommendations?seed_genres={1}&limit={2}&market=BR";
	
    private SpotifyLogin spotifyLogin;
    
    private RestTemplate restTemplate;
	
	@Autowired
	public RecomendationRepository(SpotifyLogin spotifyLogin, RestTemplate restTemplate) {
		this.spotifyLogin = spotifyLogin;
		this.restTemplate = restTemplate;
	}    
    
    public Recomendation getRecomendationListByGenre(Genre genre) {
    	HttpHeaders headers = new HttpHeaders();

    	headers.set("Authorization", "Bearer " + spotifyLogin.getJwtToken().getAccessToken());
    	
    	HttpEntity<Object> entity = new HttpEntity<Object>(headers); // Null body | GET
    	
    	ResponseEntity<Recomendation> recomendation = this.restTemplate.exchange(
    			RECOMENDATION_URL,
    			HttpMethod.GET,
    			entity,
    			Recomendation.class,
    			genre.genreName,
    			20
    			);

		return recomendation.getBody();	
    }

}
