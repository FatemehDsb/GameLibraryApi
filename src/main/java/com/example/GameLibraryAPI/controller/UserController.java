package com.example.GameLibraryAPI.controller;


import com.example.GameLibraryAPI.dto.GameResponseDTO;
import com.example.GameLibraryAPI.dto.ReviewDTO;
import com.example.GameLibraryAPI.service.GameService;
import com.example.GameLibraryAPI.service.ReviewService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    private final GameService service;
    private final ReviewService reviewService;


    public UserController(GameService service, ReviewService reviewService){
        this.service = service;
        this.reviewService = reviewService;
    }

    @GetMapping("/games/all")
    public ResponseEntity<List<GameResponseDTO>> getAllGames(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/games/page")
    public Page<GameResponseDTO> getAllGamesPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        return service.getAllGamesPage(page, size);
    }


    @GetMapping("/reviews")
    public ResponseEntity<List<ReviewDTO>> getAll(){
        return ResponseEntity.ok(reviewService.getAll());
    }

    @PostMapping("/reviews")
    public ResponseEntity<ReviewDTO> addReview(@RequestBody @Valid ReviewDTO reviewDTO){
        return ResponseEntity.ok(reviewService.addReview(reviewDTO));
    }

    @GetMapping("/games/{id}")
    public ResponseEntity<GameResponseDTO> findGameById(@PathVariable int id){
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("games/search")
    public List<GameResponseDTO> search (@RequestParam
                                         @NotBlank
                                         @Size(min = 2, message = "query must be at least 2 characters long")
                                         String query){
        return service.searchByName(query);
    }

    @GetMapping("games/filter")
    public List<GameResponseDTO> filterByRating(@RequestParam double minRating ){
        return service.findByMinRating(minRating);
    }


    @GetMapping("/games/search/by-genre")
    public List<GameResponseDTO> searchByGenre (
            @RequestParam String genre){
        return service.searchByGenre(genre);
    }


    @GetMapping("/games/{id}/summary")
    public String generateGameSummary (@PathVariable int id){
        return service.generateSummery(id);
    }


}
