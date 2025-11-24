package com.example.GameLibraryAPI.controller;

import com.example.GameLibraryAPI.config.JwtUtil;
import com.example.GameLibraryAPI.entity.LoginRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public String login (@RequestBody LoginRequestDTO userDto){

        System.out.println("*************" + userDto.getUsername() + userDto.getPassword());
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userDto.getUsername(),
                        userDto.getPassword()));

        System.out.println("🟢 authentication object" + auth);

        String role = auth.getAuthorities().iterator().next().getAuthority().replace("ROLE_", "");

        System.out.println("🟢 Generated Role: " + role);

        return jwtUtil.generateToken(userDto.getUsername(), role);
    }
}
