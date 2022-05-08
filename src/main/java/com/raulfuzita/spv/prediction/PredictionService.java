package com.raulfuzita.spv.prediction;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raulfuzita.spv.prediction.request.Prediction;
import com.raulfuzita.spv.prediction.request.PredictionRequestService;
import com.raulfuzita.spv.prediction.request.Search;

@Service
public class PredictionService {
	
	private final PredictionRequestService predictionRequestService;

	@Autowired
	public PredictionService(PredictionRequestService predictionRequestService) {
		this.predictionRequestService = predictionRequestService;
	}

	public Property searchAddress(Property property) {
		
		  String location = String.format("%s, %s %s, %s", property.address1,
		  property.address2, property.city, property.country);
		  
		  Search result = predictionRequestService.searchAddress(location);
		  System.out.println(result.toString());
		  
		  property.setCreatedAt(LocalDateTime.now());
		  property.setLongitude(result.getResponse().getLongitude());
		  property.setLatitude(result.getResponse().getLatitude());
		
		return property;
	}
	
	public Property predictProperty(Property property) {
		Prediction prediction = predictionRequestService
				.predictProperty(property);
		property.setPrice(prediction.getResponse());
		return property;
	}
}
