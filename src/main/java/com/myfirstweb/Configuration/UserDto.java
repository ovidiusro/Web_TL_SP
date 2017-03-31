package com.myfirstweb.Configuration;

import org.hibernate.validator.constraints.NotEmpty;

import org.jetbrains.annotations.NotNull;
import org.hibernate.engine.jdbc.Size;

public class UserDto {

    private String username;

    @NotEmpty
    private String password;
    @NotEmpty
    private String passwordConfirm;

    public String getPasswordConfirm() { return passwordConfirm; }
    public void setPasswordConfirm(String passwordConfirm) { this.passwordConfirm = passwordConfirm; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

}
