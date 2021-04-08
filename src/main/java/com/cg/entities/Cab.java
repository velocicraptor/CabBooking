package com.cg.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cab {
	@Id
	@Column(name="cab_id",unique = true, nullable = false)
	private int cabId;
	@Column(name="car_type")
	private String carType;
	@Column(name="per_km_rate")
	private float perKmRate;
	@Column(name="booked")
	boolean booked;
	public Cab() {

	}
	
	public Cab(String carType, float perKmRate,boolean booked) {
		this.carType = carType;
		this.perKmRate = perKmRate;
		
	}

	public int getCabId() {
		return cabId;
	}
	public void setCabId(int cabId) {
		this.cabId = cabId;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public float getPerKmRate() {
		return perKmRate;
	}
	public void setPerKmRate(float perKmRate) {
		this.perKmRate = perKmRate;
	}
	
	@Override
	public String toString() {
		return "Cab [cabId=" + cabId + ", carType=" + carType + ", perKmRate=" + perKmRate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + cabId;
		result = prime * result + ((carType == null) ? 0 : carType.hashCode());
		result = prime * result + Float.floatToIntBits(perKmRate);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cab other = (Cab) obj;
		if (cabId != other.cabId)
			return false;
		if (carType == null) {
			if (other.carType != null)
				return false;
		} else if (!carType.equals(other.carType))
			return false;
		if (Float.floatToIntBits(perKmRate) != Float.floatToIntBits(other.perKmRate))
			return false;
		return true;
	}
	
}