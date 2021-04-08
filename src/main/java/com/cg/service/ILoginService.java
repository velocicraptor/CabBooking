package com.cg.service;

import com.cg.dto.AdminDto;
import com.cg.dto.CustomerDto;
import com.cg.dto.DriverDto;

public interface ILoginService {
	public boolean login(String username, String password, String loginType);

	public boolean registerAdmin(AdminDto adminDto);

	public boolean registerCustomer(CustomerDto customerDto);

	public boolean registerDriver(DriverDto driverDto);

}
