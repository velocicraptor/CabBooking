package com.cg.dto;

public class CustomerDto extends AbstractUserDto {

	private int customerId;
	
	public CustomerDto() {

	}
	
	public CustomerDto(String username, String password, String mobileNumber, String email) {
		super(username, password, mobileNumber, email);
	}


	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		super.toString();
		return "Customer [customerId=" + customerId + "]";
	}
	

	
}
