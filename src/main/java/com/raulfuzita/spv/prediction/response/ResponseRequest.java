package com.raulfuzita.spv.prediction.response;

public class ResponseRequest<T> {

	protected final T data;
	protected final String message;
	protected final int status;
	protected final String error;
	
	public static class Builder<T> {
		
		private final T data;
		private String message;
		private int status;
		private String error;
		
		public Builder(T data) {
			this.data 		= data;
			this.message 	= "";
			this.status 	= 200;
			this.error 		= "";
		}
		
		public Builder<T> message(String message) {
			this.message = message;
			return this;
		}
		
		public Builder<T> status(int code) {
			this.status = code;
			return this;
		}
		
		public Builder<T> error(String error) {
			this.error = error;
			return this;
		}
		
		public ResponseRequest<T> build() {
			return new ResponseRequest<>(this);
		}
	}
	
	public ResponseRequest(Builder<T> builder) {
		this.data		= builder.data;
		this.message 	= builder.message;
		this.status		= builder.status;
		this.error		= builder.error;
	}

	public T getData() {
		return data;
	}

	public String getMessage() {
		return message;
	}

	public int getStatus() {
		return status;
	}

	public String getError() {
		return error;
	}

	@Override
	public String toString() {
		return "ReponseRequest [data=" + data + ", message=" + message 
				+ ", status=" + status + ", error=" + error
				+ "]";
	}
}
