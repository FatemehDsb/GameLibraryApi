package com.example.GameLibraryAPI.dto;

import com.example.GameLibraryAPI.entity.Role;

import java.util.Set;

public class UserDTO {
    private String username;
    private String password;
    private Set<Role> roles;


    public UserDTO() {
    }

    public UserDTO(String username, Set<Role> roles) {
        this.username = username;
        this.roles = roles;
    }

    public UserDTO(String username, Set<Role> roles, String password) {
        this.username = username;
        this.roles = roles;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}

