package com.example.GameLibraryAPI.controller;

import com.example.GameLibraryAPI.dto.GameRequestDTO;
import com.example.GameLibraryAPI.dto.GameResponseDTO;
import com.example.GameLibraryAPI.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {
    private GameService service;

    public GameController(GameService service){
        this.service = service;
    }

@GetMapping
    public ResponseEntity<List<GameResponseDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
}

}
