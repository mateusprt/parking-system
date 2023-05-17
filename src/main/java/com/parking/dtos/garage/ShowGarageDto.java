package com.parking.dtos.garage;

import java.math.BigDecimal;
import java.util.Date;

import com.parking.dtos.state.StateDto;

public class ShowGarageDto {
	
	private String zipCode;
	private String street;
	private String district;
	private String addressNumber;
	private StateDto state;
	private BigDecimal rateCompact;
	private BigDecimal rateRegular;
	private BigDecimal rateLarge;
	private Date createdAt;
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
	public StateDto getState() {
		return state;
	}
	public void setState(StateDto state) {
		this.state = state;
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
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	
	
}
