package com.example.GameLibraryAPI.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String jwtSecret;

    public String generateToken(UserDetails userDetails){

        Map<String,Object> claims = new HashMap<>();

        claims.put("roles", userDetails
                .getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .toList());

        String token = Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000*60*5))
                .setClaims(claims)
                .signWith(Keys.hmacShaKeyFor(jwtSecret.getBytes()), SignatureAlgorithm.HS256)
                .compact();

        return token;
    }

    private Claims extractAllClaims(String token){

        return Jwts.parserBuilder()
                .setSigningKey(jwtSecret.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody();

    }

    public String extractUserName(String token){
        return extractAllClaims(token).getSubject();
    }

    public List<String>  extractRoles(String token){
        return extractAllClaims(token).get("roles", List.class);
    }
}

