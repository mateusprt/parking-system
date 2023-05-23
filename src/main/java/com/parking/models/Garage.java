package com.parking.models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="garages")
public class Garage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "zip_code")
	@NotEmpty(message = "Zip code can't be blank")
	private String zipCode;
	
	@Column
	private String street;
	
	@Column
	private String district;
	
	@Column(name = "address_number")
	private String addressNumber;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="state_id")
	@NotNull(message = "State can't be blank")
	private State state;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="city_id")
	@NotNull(message = "City can't be blank")
	private City city;
	
	@OneToMany(mappedBy = "garage", fetch = FetchType.LAZY)
	private List<Spot> spots;
	
	@Column(name = "rate_compact", precision = 10, scale=2)
	@NotNull(message = "Rate compact can't be blank")
	private BigDecimal rateCompact;
	
	@Column(name = "rate_regular", precision = 10, scale=2)
	@NotNull(message = "Rate regular can't be blank")
	private BigDecimal rateRegular;
	
	@Column(name = "rate_large", precision = 10, scale=2)
	@NotNull(message = "Rate large can't be blank")
	private BigDecimal rateLarge;
	
	@Column(name="created_at")
	@CreationTimestamp
	private Date createdAt;
	
	@Column(name="updated_at")
	@UpdateTimestamp
	private Date updatedAt;

	public Garage() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
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

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Spot> getSpots() {
		return spots;
	}

	public void setSpots(List<Spot> spots) {
		this.spots = spots;
	}

	@Override
	public int hashCode() {
		return Objects.hash(addressNumber, city, createdAt, district, id, rateCompact, rateLarge, rateRegular, state,
				street, updatedAt, zipCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Garage other = (Garage) obj;
		return Objects.equals(addressNumber, other.addressNumber) && Objects.equals(city, other.city)
				&& Objects.equals(createdAt, other.createdAt) && Objects.equals(district, other.district)
				&& Objects.equals(id, other.id) && Objects.equals(rateCompact, other.rateCompact)
				&& Objects.equals(rateLarge, other.rateLarge) && Objects.equals(rateRegular, other.rateRegular)
				&& Objects.equals(state, other.state) && Objects.equals(street, other.street)
				&& Objects.equals(updatedAt, other.updatedAt) && Objects.equals(zipCode, other.zipCode);
	}
	
	
	
}
