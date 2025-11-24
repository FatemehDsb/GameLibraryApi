package com.example.GameLibraryAPI.controller;


import com.example.GameLibraryAPI.dto.GameResponseDTO;
import com.example.GameLibraryAPI.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final GameService service;

    public UserController(GameService service){
        this.service = service;
    }

    @GetMapping("/games")
    public ResponseEntity<List<GameResponseDTO>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

}
