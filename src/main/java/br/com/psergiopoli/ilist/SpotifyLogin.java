package br.com.psergiopoli.ilist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import br.com.psergiopoli.ilist.model.Spotify.JwtToken;

@Component
@Scope("singleton")
public class SpotifyLogin {
	
	public static final String LOGIN_URL = "https://accounts.spotify.com/api/token";
	
    @Value("${spotifykey}")
    private String spotifykey;
    
    private RestTemplate restTemplate;
    
    private JwtToken jwtToken;
    
	@Autowired
	public SpotifyLogin(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}    

	public JwtToken getJwtToken() {
		
		if (jwtToken != null) { // Fazer verificação da expiração
			return jwtToken;
		}		
		
    	HttpHeaders headers = new HttpHeaders();
    	headers.set("Authorization", "Basic " + spotifykey);
    	headers.set("Content-Type", "application/x-www-form-urlencoded");
    	
		MultiValueMap<String, String> formData = new LinkedMultiValueMap<String, String>();
		formData.add("grant_type", "client_credentials");
    	
    	HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(formData, headers);
		
    	ResponseEntity<JwtToken> jwtToken = restTemplate.exchange(
    			LOGIN_URL,
    			HttpMethod.POST,
    			entity,
    			JwtToken.class
    			);
    	
    	this.jwtToken = jwtToken.getBody();
    	
    	return this.jwtToken;
	}
}
