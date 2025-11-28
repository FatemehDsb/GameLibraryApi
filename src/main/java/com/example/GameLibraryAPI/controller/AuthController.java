package com.example.GameLibraryAPI.controller;

import com.example.GameLibraryAPI.dto.LoginRequestDTO;
import com.example.GameLibraryAPI.service.CustomUserDetailService;

import com.example.GameLibraryAPI.service.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class AuthController {


    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailService customUserDetailService;
    private final JwtService jwtService;


    public AuthController(AuthenticationManager authenticationManager, CustomUserDetailService customUserDetailService, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.customUserDetailService = customUserDetailService;
        this.jwtService = jwtService;
    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> login (@RequestBody LoginRequestDTO loginRequestDTO){


        Authentication authenticatedObject = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequestDTO.getUsername(),
                        loginRequestDTO.getPassword()));

        UserDetails userDetails =  (UserDetails) authenticatedObject.getPrincipal();

        String token = jwtService.generateToken(userDetails);

        return ResponseEntity.ok(token);
    }
}
