package com.example.GameLibraryAPI.config;

import com.example.GameLibraryAPI.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class JwtFilter extends OncePerRequestFilter
{
    private  final JwtService jwtService;

    public JwtFilter(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String header= request.getHeader("Authorization");
        if(header != null && header.startsWith("Bearer "))
        {
            try{
                String token= header.substring(7).trim();
                String username = jwtService.extractUserName(token);
                List<String> roles = jwtService.extractRoles(token);
                List<SimpleGrantedAuthority> authorities = roles.stream()
                        .map(SimpleGrantedAuthority::new)
                        .toList();



                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(
                               username, null, authorities);

                SecurityContextHolder.getContext().setAuthentication(authenticationToken);

            }catch (Exception e){
                System.out.println(e.getMessage());

            }

        }
        filterChain.doFilter(request, response);
    }

}
