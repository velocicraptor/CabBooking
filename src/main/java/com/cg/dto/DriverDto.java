package com.cg.dto;

public class DriverDto extends AbstractUserDto {

	private int driverId;
	private String licenseNo;
	private CabDto cab;
	private float rating;
	
	public DriverDto() {

	}
	   
	public DriverDto( String username, String password, String mobileNumber, String email, String licenseNo, CabDto cab, float rating) {
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
	public CabDto getCab() {
		return cab;
	}
	public void setCab(CabDto cab) {
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
				+ "]";
	}
	
	
}