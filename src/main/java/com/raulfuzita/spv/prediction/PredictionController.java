package com.raulfuzita.spv.prediction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raulfuzita.spv.prediction.response.ResponseRequest;

@CrossOrigin(origins="http://localhost:8080")
@RestController
@RequestMapping(path = "api/v1/prediction")
public class PredictionController {

	private final PredictionService predictionService;

	@Autowired
	public PredictionController(PredictionService predictionService) {
		this.predictionService = predictionService;
	}
	
	protected Property predictProperty(Property property) {
		Property propertyData = predictionService.searchAddress(property);
		System.out.println(propertyData);
		
		propertyData = predictionService.predictProperty(propertyData);
		System.out.println(propertyData);
		return propertyData;
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseRequest<Property>> predict(@RequestBody Property property) {
		
		Property propertyData = predictProperty(property);
		
		ResponseRequest<Property> response = new ResponseRequest.Builder<>(propertyData)
				.message("success")
				.status(200)
				.error("no error").build();
		// return new ResponseEntity<String>(json.toString(), HttpStatus.OK);
		return ResponseEntity.ok(response);
	}
	
}
