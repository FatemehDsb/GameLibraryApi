package com.example.GameLibraryAPI.service;

import com.example.GameLibraryAPI.dto.UserDTO;
import com.example.GameLibraryAPI.entity.AppUser;
import com.example.GameLibraryAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    @Autowired
    private PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<UserDTO> getAllUsers(){
        return userRepository.findAll()
                .stream()
                .map(user ->
                        new UserDTO(user.getUsername(), user.getRoles()))
                .toList();

    }

    public UserDTO addUser(UserDTO userDto){
        AppUser appUser = new AppUser(userDto.getUsername(),
                passwordEncoder.encode(userDto.getPassword()));
        appUser.setRoles(userDto.getRoles());

        AppUser savedUser = userRepository.save(appUser);

        UserDTO userDTO = new UserDTO(
                savedUser.getUsername(),
                savedUser.getRoles()
        );
        return userDTO;

    }






}
