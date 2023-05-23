package com.parking.models;

import java.math.BigDecimal;
import java.util.Date;
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
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "reservations")
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@NotNull(message = "cod can't be blank")
	private String cod;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	@NotNull(message = "user can't be blank")
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "garage_id")
	@NotNull(message = "garage can't be blank")
	private Garage garage;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "spot_id")
	@NotNull(message = "spot can't be blank")
	private Spot spot;
	
	@Column(name = "start_time")
	@NotNull(message = "start_time can't be blank")
	private Date startTime;
	
	@Column(name = "end_time")
	private Date endTime;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal value;
	
	@Column
	@NotNull(message = "paid can't be blank")
	private boolean paid;
	
	@CreationTimestamp
	@Column(name = "created_at")
	private Date createdAt;
	
	@UpdateTimestamp
	@Column(name = "updated_at")
	private Date updatedAt;
	
	public Reservation() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Garage getGarage() {
		return garage;
	}

	public void setGarage(Garage garage) {
		this.garage = garage;
	}

	public Spot getSpot() {
		return spot;
	}

	public void setSpot(Spot spot) {
		this.spot = spot;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
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

	@Override
	public int hashCode() {
		return Objects.hash(cod, createdAt, endTime, garage, id, paid, spot, startTime, updatedAt, user, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation other = (Reservation) obj;
		return Objects.equals(cod, other.cod) && Objects.equals(createdAt, other.createdAt)
				&& Objects.equals(endTime, other.endTime) && Objects.equals(garage, other.garage)
				&& Objects.equals(id, other.id) && paid == other.paid && Objects.equals(spot, other.spot)
				&& Objects.equals(startTime, other.startTime) && Objects.equals(updatedAt, other.updatedAt)
				&& Objects.equals(user, other.user) && Objects.equals(value, other.value);
	}

	
}
