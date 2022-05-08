package com.raulfuzita.spv.prediction.request;

public class Search {

	private Response response = new Response();
	private int status;
	
	public class Response {
		String address;
		double latitude;
		double longitude;
		
		public Response() {}
		public Response(String address, double latitude, double longitude) {
			this.address = address;
			this.latitude = latitude;
			this.longitude = longitude;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public double getLatitude() {
			return latitude;
		}
		public void setLatitude(double latitude) {
			this.latitude = latitude;
		}
		public double getLongitude() {
			return longitude;
		}
		public void setLongitude(double longitude) {
			this.longitude = longitude;
		}
		@Override
		public String toString() {
			return "Response [address=" + address + ", latitude=" + latitude + ", longitude=" 
					+ longitude + "]";
		}
		
	}

	public Search() {}

	public Search(Response response, int status) {
		this.response = response;
		this.status = status;
	}

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
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
		return "Search [response=" + response + ", status=" + status + "]";
	}
	
}
