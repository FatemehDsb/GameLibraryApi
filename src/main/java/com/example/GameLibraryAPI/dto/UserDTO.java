package com.example.GameLibraryAPI.dto;

import com.example.GameLibraryAPI.entity.Role;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

public class UserDTO {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private Set<Role> roles;




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

