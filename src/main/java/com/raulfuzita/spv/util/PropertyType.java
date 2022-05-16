package com.raulfuzita.spv.util;

public enum PropertyType {
	INTANCE;
	
	public String valueOf(int code) {
		switch (code) {
		case 0:
			return "Apartment";
		case 1:
			return "Bungalow";
		case 2:
			return "Detached";
		case 3:
			return "Duplex";
		case 4:
			return "End of Terrace";
		case 5:
			return "House";
		case 6:
			return "Semi-D";
		case 7:
			return "Site";
		case 8:
			return "Studio";
		case 9:
			return "Terrace";
		case 10:
			return "Townhouse";
		default:
			return "Unknown";
		}
	}
}
