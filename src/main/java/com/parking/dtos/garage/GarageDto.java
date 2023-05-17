package com.parking.dtos.garage;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;

public class GarageDto {
	
	@JsonProperty("zip_code")
	@NotNull(message = "zip_code can't be blank")
	private String zipCode;
	
	private String street;
	private String district;
	
	@JsonProperty("address_number")
	private String addressNumber;
	
	@JsonProperty("rate_compact")
	@NotNull(message = "rate_compact can't be blank")
	private BigDecimal rateCompact;
	
	@JsonProperty("rate_regular")
	@NotNull(message = "rate_regular can't be blank")
	private BigDecimal rateRegular;
	
	@JsonProperty("rate_large")
	@NotNull(message = "rate_large can't be blank")
	private BigDecimal rateLarge;
	
	public String getZipCode() {
		return zipCode;
	}
	
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getAddressNumber() {
		return addressNumber;
	}
	public void setAddressNumber(String addressNumber) {
		this.addressNumber = addressNumber;
	}
	public BigDecimal getRateCompact() {
		return rateCompact;
	}
	public void setRateCompact(BigDecimal rateCompact) {
		this.rateCompact = rateCompact;
	}
	public BigDecimal getRateRegular() {
		return rateRegular;
	}
	public void setRateRegular(BigDecimal rateRegular) {
		this.rateRegular = rateRegular;
	}
	public BigDecimal getRateLarge() {
		return rateLarge;
	}
	public void setRateLarge(BigDecimal rateLarge) {
		this.rateLarge = rateLarge;
	}

}
