package com.travel.Agent.dto;

public class AgentDTO {
	
	public AgentDTO(Long id, String name, String surname, String email, String password, String address,
			String businessRegNum, boolean approved, String newPassword, String repeatPassword) {
		
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.address = address;
		this.businessRegNum = businessRegNum;
		this.approved = approved;
		this.newPassword = newPassword;
		this.repeatPassword = repeatPassword;
	}
	
	public AgentDTO() {
		
	}

	private Long id;
	
	private String name;
	
	private String surname;
	
	private String email;
	
	private String password;
	
	private String address;
	
	private String businessRegNum;
	
	private boolean approved;
	
	private String newPassword;
	
	private String repeatPassword;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBusinessRegNum() {
		return businessRegNum;
	}

	public void setBusinessRegNum(String businessRegNum) {
		this.businessRegNum = businessRegNum;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getRepeatPassword() {
		return repeatPassword;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}

}
