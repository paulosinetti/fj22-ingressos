package br.com.caelum.ingresso.rest;

import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import br.com.caelum.ingresso.modelo.DetalhesDoFilme;
import br.com.caelum.ingresso.modelo.Filme;

@Component
public class ImdbClient {
	
	private Logger logger = Logger.getLogger(ImdbClient.class);
	
	public <T> Optional<T> request(Filme filme, Class<T> typeClass){
		
		RestTemplate client = new RestTemplate();
		
		String titulo = filme.getNome().replaceAll(" ", "+");
		
		String url = String.format("https://imdb-fj22.herokuapp.com/imdb?title=%s", titulo);
		
		
		
		try {
			return Optional.of(client.getForObject(url, typeClass));
		} catch (RestClientException e) {
			logger.error(e.getMessage(), e);
			return Optional.empty();
		}
	}

}
