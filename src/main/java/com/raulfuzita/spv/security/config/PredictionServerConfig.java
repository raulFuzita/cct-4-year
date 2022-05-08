package com.raulfuzita.spv.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.boot.context.properties.bind.DefaultValue;

@ConstructorBinding
@ConfigurationProperties("prediction-server")
public class PredictionServerConfig {

	private final String url;
	private final String apiKey;
	private final String apiKeyTest;
	
	@Autowired
	public PredictionServerConfig(String url, 
			@DefaultValue("") String apiKey, 
			@DefaultValue("") String apiKeyTest) {
		this.url = url;
		this.apiKey = apiKey;
		this.apiKeyTest = apiKeyTest;
	}
	
	public String getUrl() {
		return url;
	}

	public String getApiKey() {
		return apiKey;
	}

	public String getApiKeyTest() {
		return apiKeyTest;
	}
	
}
