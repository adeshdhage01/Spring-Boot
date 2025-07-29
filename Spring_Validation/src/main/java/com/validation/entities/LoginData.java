package com.validation.entities;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginData {

	@NotNull(message = "User name con not be null")
	@Size(min = 3, max = 12, message = "size must be 3 to 12 characters" )
    private String userName;
    private String email;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "LoginData [userName=" + userName + ", email=" + email + "]";
    }
}
