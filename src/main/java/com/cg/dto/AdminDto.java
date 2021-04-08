package com.cg.dto;

public class AdminDto extends AbstractUserDto {

	private int adminId;

	public AdminDto() {

	}

	public AdminDto(String username, String password, String mobileNumber, String email) {
		super(username, password, mobileNumber, email);
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	@Override
	public String toString() {
		
		return "Admin [adminId=" + adminId + "]" +super.toString();
	}

	


	
	
}