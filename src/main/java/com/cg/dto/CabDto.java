package com.cg.dto;

public class CabDto {

	private int cabId;
	private String carType;
	private float perKmRate;
	private boolean booked;
	
	public CabDto() {

	}
	
	public CabDto(String carType, float perKmRate,boolean booked) {
		this.carType = carType;
		this.perKmRate = perKmRate;
		this.booked = booked;
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
	
	public boolean getBooked() {
		return booked;
	}

	public void setBooked(boolean booked) {
		this.booked = booked;
	}
	
	@Override
	public String toString() {
		return "Cab [cabId=" + cabId + ", carType=" + carType + ", perKmRate=" + perKmRate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (booked ? 1231 : 1237);
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
		CabDto other = (CabDto) obj;
		if (booked != other.booked)
			return false;
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