package com.raulfuzita.spv.prediction;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.raulfuzita.spv.user.User;

@Entity
public class Property {
	
	@Id
	@SequenceGenerator(
			name = "property_sequence",
			sequenceName = "property_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "property_sequence"
	)
	protected long id;
	
	protected String name;
	
	@Column(nullable = false)
	protected String address1;
	protected String address2 = "";
	
	@Column(nullable = false)
	protected String city;
	
	@Column(nullable = false)
	protected String country;
	
	@Column(columnDefinition = "integer default 0")
	protected int bedroom;
	
	@Column(columnDefinition = "integer default 0")
	protected int bathroom;
	
	@Column(columnDefinition = "integer default 0")
	protected int propertySize;
	
	@Column(columnDefinition = "integer default 0")
	protected int propertyType;
	
	@Column(columnDefinition = "integer default 2022")
	protected int year;
	protected double price;
	
	protected double longitude;
	protected double latitude;
	
	@Column(nullable = false)
	protected LocalDateTime createdAt;
	
	@ManyToOne
	@JoinColumn(
			nullable = false,
			name = "user_id"
	)
	protected User user;

	public Property() {}

	public Property(long id, String address1, String city, 
			String country, LocalDateTime createdAt, User user) {
		this.id = id;
		this.address1 = address1;
		this.city = city;
		this.country = country;
		this.createdAt = createdAt;
		this.user = user;
	}

	public Property(String address1, String city, String country, 
			LocalDateTime createdAt, User user) {
		this.address1 = address1;
		this.city = city;
		this.country = country;
		this.createdAt = createdAt;
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getBedroom() {
		return bedroom;
	}

	public void setBedroom(int bedroom) {
		this.bedroom = bedroom;
	}

	public int getBathroom() {
		return bathroom;
	}

	public void setBathroom(int bathroom) {
		this.bathroom = bathroom;
	}

	public int getPropertySize() {
		return propertySize;
	}

	public void setPropertySize(int propertySize) {
		this.propertySize = propertySize;
	}

	public int getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(int propertyType) {
		this.propertyType = propertyType;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Property [id=" + id + ", address1=" + address1 + ", address2=" + address2 + ", city=" + city
				+ ", country=" + country + ", bedroom=" + bedroom + ", bathroom=" + bathroom + ", propertySize="
				+ propertySize + ", propertyType=" + propertyType + ", year=" + year + ", price=" + price
				+ ", longitude=" + longitude + ", latitude=" + latitude + ", createdAt=" + createdAt + ", user=" + user
				+ "]";
	}
	
}
