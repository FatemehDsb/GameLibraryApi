package com.example.GameLibraryAPI.service;

import com.example.GameLibraryAPI.dto.UserDTO;
import com.example.GameLibraryAPI.entity.AppUser;
import com.example.GameLibraryAPI.exception.ResourceNotFoundException;
import com.example.GameLibraryAPI.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
                .toList()
                ;

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


    public UserDTO updateUser(Long id, UserDTO userDTO){

        Optional<AppUser> userDB = userRepository.findById(id);
        if(userDB.isPresent()){
            AppUser user = userDB.get();
            user.setUsername(userDTO.getUsername());
            user.setRoles(userDTO.getRoles());
            user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

            AppUser updated = userRepository.save(user);
            return new UserDTO(
                    updated.getUsername(),
                    updated.getRoles(),
                    updated.getPassword()
            );
        }
        throw new ResourceNotFoundException("User not found");
    }

    public UserDTO getUserById(Long id){
      AppUser appUser = userRepository.findById(id)
              .orElseThrow(()-> new ResourceNotFoundException("user with this id is not found!"));
      return  new UserDTO(appUser.getUsername(), appUser.getRoles());
    }

    public void deleteUserById(Long id){
         userRepository.deleteById(id);
    }



}
