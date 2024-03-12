package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Credentials {
    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;

    public Credentials(){}

    // Constructor for initializing credentials
    public Credentials(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Setter for email
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter for password
    public String getPassword() {
        return password;
    }

    // Setter for password
    public void setPassword(String password) {
        this.password = password;
    }
}
