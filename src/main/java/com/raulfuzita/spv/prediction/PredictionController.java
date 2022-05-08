package com.raulfuzita.spv.prediction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raulfuzita.spv.prediction.request.Prediction;

@RestController
@RequestMapping(path = "api/v1/prediction")
public class PredictionController {

	private final PredictionService predictionService;

	@Autowired
	public PredictionController(PredictionService predictionService) {
		this.predictionService = predictionService;
	}
	
	@PostMapping
	public ResponseEntity<Object> predict(@RequestBody Property property) {
		Property propertyData = predictionService.searchAddress(property);
		System.out.println(propertyData);
		
		propertyData = predictionService.predictProperty(propertyData);
		System.out.println(propertyData);
		
		return new ResponseEntity<Object>("It works", HttpStatus.OK);
	}
	
}
