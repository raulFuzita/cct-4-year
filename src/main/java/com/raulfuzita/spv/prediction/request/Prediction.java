package com.raulfuzita.spv.prediction.request;

public class Prediction {

	private double response;
	private int status;
	
	public Prediction() {}

	public Prediction(double response, int status) {
		this.response = response;
		this.status = status;
	}

	public double getResponse() {
		return response;
	}

	public void setResponse(double response) {
		this.response = response;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Prediction [response=" + response + ", status=" + status + "]";
	}
	
}
