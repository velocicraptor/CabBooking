package com.cg.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="driver")
public class Driver extends AbstractUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="driver_id",unique = true, nullable = false)
	private int driverId;
	@Column(name="license_no",unique = true, nullable = false)
	private String licenseNo;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cab_id",unique=true)
	private Cab cab;
	private float rating;
	@Column(name="username",unique = true, nullable = false)
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="mobile_number",unique = true, nullable = false)
	private String mobileNumber;
	@Column(name="email",unique = true, nullable = false)
	private  String email;
	@Column(name="address")
	private String address;
	
	public Driver() {

	}
	   
	public Driver( String username, String password, String mobileNumber, String email, String licenseNo, Cab cab, float rating) {
	        super(username, password, mobileNumber, email);
	        this.licenseNo = licenseNo;
	        this.cab = cab;
	        this.rating = rating;
	    }
	

	public int getDriverId() {
		return driverId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	public Cab getCab() {
		return cab;
	}
	public void setCab(Cab cab) {
		this.cab = cab;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Driver [driverId=" + driverId + ", licenseNo=" + licenseNo + ", cab=" + cab + ", rating=" + rating
				+ ", username=" + username + ", password=" + password + ", mobileNumber=" + mobileNumber + ", email="
				+ email + ", address=" + address + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((cab == null) ? 0 : cab.hashCode());
		result = prime * result + driverId;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((licenseNo == null) ? 0 : licenseNo.hashCode());
		result = prime * result + ((mobileNumber == null) ? 0 : mobileNumber.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + Float.floatToIntBits(rating);
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Driver other = (Driver) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (cab == null) {
			if (other.cab != null)
				return false;
		} else if (!cab.equals(other.cab))
			return false;
		if (driverId != other.driverId)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (licenseNo == null) {
			if (other.licenseNo != null)
				return false;
		} else if (!licenseNo.equals(other.licenseNo))
			return false;
		if (mobileNumber == null) {
			if (other.mobileNumber != null)
				return false;
		} else if (!mobileNumber.equals(other.mobileNumber))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (Float.floatToIntBits(rating) != Float.floatToIntBits(other.rating))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	

	
	
}