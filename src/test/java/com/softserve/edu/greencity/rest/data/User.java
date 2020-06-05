package com.softserve.edu.greencity.rest.data;

public class User {
	private String email;
	private String name;
	private String password;
	//
	private String verifyURL;
    private String verifytoken;
    private String verifyUserId;
    //

	public User(String email, String name, String password) {
		this.email = email;
		this.name = name;
		this.password = password;
	}

	// setters

	public void setEmail(String email) {
		this.email = email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setVerifyURL(String verifyURL) {
        this.verifyURL = verifyURL;
    }

    public void setVerifytoken(String verifytoken) {
        this.verifytoken = verifytoken;
    }

    public void setVerifyUserId(String verifyUserId) {
        this.verifyUserId = verifyUserId;
    }

	// getters

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}
	
	public String getVerifyURL() {
        return verifyURL;
    }

    public String getVerifytoken() {
        return verifytoken;
    }

    public String getVerifyUserId() {
        return verifyUserId;
    }

	@Override
	public String toString() {
		return "User [email=" + email 
				+ ", name=" + name 
				+ ", password=" + password + "]";
	}

}
