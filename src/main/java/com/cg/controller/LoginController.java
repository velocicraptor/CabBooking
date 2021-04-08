package com.cg.controller;

import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.AdminDto;
import com.cg.dto.CustomerDto;
import com.cg.dto.DriverDto;
import com.cg.service.ILoginService;
import com.fasterxml.jackson.databind.node.ObjectNode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private ILoginService LoginService;

	/*
	 *	Method Name - login
	 *	Return Type - Boolean
	 *	Description - login of users 
	 */
	@PostMapping(value = "/login")
	public boolean login(@RequestBody ObjectNode loginObj) {
		String username = (String.valueOf(loginObj.get("username"))).replaceAll("\"", "");
		String password = (String.valueOf(loginObj.get("password"))).replaceAll("\"", "");
		String loginType = (String.valueOf(loginObj.get("loginType"))).replaceAll("\"", "");
		return LoginService.login(username, password, loginType);
	}

	/*
	 *	Method Name - RegisterUser
	 * 	Parameter List - AdminDto object
	 *	Return Type - Boolean
	 *	Description - register a admin object into the database 
	 */
	@PostMapping(value = "/register/admin")
	public boolean registerUser(@RequestBody AdminDto admin) {
		return LoginService.registerAdmin(admin);
	}

	/*
	 *	Method Name - RegisterUser
	 * 	Parameter List - CustomerDto object
	 *	Return Type - Boolean
	 *	Description - register a Customer object into the database 
	 */
	@PostMapping(value = "/register/customer")
	public boolean registerUser(@RequestBody CustomerDto customer) {
		return LoginService.registerCustomer(customer);
	}

	/*
	 *	Method Name - RegisterUser
	 * 	Parameter List - DriverDto object
	 *	Return Type - Boolean
	 *	Description - register a driver object into the database 
	 */
	@PostMapping(value = "/register/driver")
	public boolean registerUser(@RequestBody DriverDto driver) {
		return LoginService.registerDriver(driver);
	}

}
