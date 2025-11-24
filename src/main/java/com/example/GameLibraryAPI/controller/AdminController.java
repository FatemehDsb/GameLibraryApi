package com.example.GameLibraryAPI.controller;

import com.example.GameLibraryAPI.dto.GameRequestDTO;
import com.example.GameLibraryAPI.dto.GameResponseDTO;
import com.example.GameLibraryAPI.dto.UserDTO;
import com.example.GameLibraryAPI.service.GameService;
import com.example.GameLibraryAPI.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final GameService gameService;

    public AdminController(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getALlUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/games")
    public ResponseEntity<List<GameResponseDTO>> getAllGames() { return ResponseEntity.ok(gameService.getAll());}

    @PostMapping("/games")
    public ResponseEntity<GameResponseDTO> addGame(@RequestBody GameRequestDTO gameRequestDTO){
        System.out.println("***REQUEST BODY");
        return ResponseEntity.ok(gameService.addGame(gameRequestDTO));
    }

    @PostMapping("/users")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userdto){
        System.out.println("********* SAVE USER REQUEST*****");
        return ResponseEntity.ok(userService.addUser(userdto));
    }


}
