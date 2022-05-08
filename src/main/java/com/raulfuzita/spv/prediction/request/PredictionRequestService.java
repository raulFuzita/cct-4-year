package com.raulfuzita.spv.prediction.request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.raulfuzita.spv.prediction.Property;
import com.raulfuzita.spv.security.config.PredictionServerConfig;

@EnableConfigurationProperties(PredictionServerConfig.class)
@Service
public class PredictionRequestService {

	private final WebClient webClient;
	private final String API_KEY;
	
	@Autowired
	public PredictionRequestService(WebClient.Builder webClientBuilder, 
			PredictionServerConfig predictionServer) {
		this.webClient = webClientBuilder
				.baseUrl(predictionServer.getUrl()).build();
		this.API_KEY = predictionServer.getApiKeyTest();
	}
	
	public Search searchAddress(String address) {
		
		MultiValueMap<String, String> bodyValues = new LinkedMultiValueMap<>();
		bodyValues.add("address", address);
		
		return this.webClient.post().uri(uriBuilder -> uriBuilder
							.path("/search")
							.queryParam("api_key", API_KEY).build())
						.contentType(MediaType.APPLICATION_FORM_URLENCODED)
						.accept(MediaType.APPLICATION_JSON)
						.body(BodyInserters.fromFormData(bodyValues))
						.retrieve().bodyToMono(Search.class).block();
		
	}

	public Prediction predictProperty(Property property) {
		
		MultiValueMap<String, String> bodyValues = new LinkedMultiValueMap<>();
		bodyValues.add("bedrooms", Integer.toString(property.getBedroom()));
		bodyValues.add("bathrooms", Integer.toString(property.getBathroom()));
		bodyValues.add("property_size", Integer.toString(property.getPropertySize()));
		bodyValues.add("longitude", Double.toString(property.getLongitude()));
		bodyValues.add("latitude", Double.toString(property.getLatitude()));
		bodyValues.add("property_type", Integer.toString(property.getPropertyType()));
		bodyValues.add("year", Integer.toString(property.getYear()));
		
		System.out.println(bodyValues.toString());
		
		return this.webClient.post().uri(uriBuilder -> uriBuilder
							.path("/predict")
							.queryParam("api_key", API_KEY).build())
						.contentType(MediaType.APPLICATION_FORM_URLENCODED)
						.accept(MediaType.APPLICATION_JSON)
						.body(BodyInserters.fromFormData(bodyValues))
						.retrieve().bodyToMono(Prediction.class).block();
	}
}
