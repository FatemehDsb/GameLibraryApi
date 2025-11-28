package com.example.GameLibraryAPI.service;

import com.example.GameLibraryAPI.entity.AppUser;
import com.example.GameLibraryAPI.entity.CustomUserDetails;
import com.example.GameLibraryAPI.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

private final UserRepository userRepository;

    public CustomUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AppUser appUser = userRepository.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("user not found!"));

        return new User(appUser.getUsername(),
                appUser.getPassword(),
                appUser.getRoles()
                        .stream()
                        .map(role -> new SimpleGrantedAuthority(role.getName()))
                        .toList());
    }
}