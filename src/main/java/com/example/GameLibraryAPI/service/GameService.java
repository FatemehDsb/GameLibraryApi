package com.example.GameLibraryAPI.service;

import com.example.GameLibraryAPI.dto.GameRequestDTO;
import com.example.GameLibraryAPI.dto.GameResponseDTO;
import com.example.GameLibraryAPI.entity.Category;
import com.example.GameLibraryAPI.entity.Game;
import com.example.GameLibraryAPI.exception.ResourceNotFoundException;
import com.example.GameLibraryAPI.repository.GameRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class GameService {

    private GameRepository repository;

    public GameService(GameRepository repository){
        this.repository = repository;
    }

    public List<GameResponseDTO> getAll(){
        return repository.findAll()
                .stream()
        .map(g-> new GameResponseDTO( g.getTitle(),g.getGenre(), g.getRating(), g.getReleaseYear())
        ).toList();
    }

    public GameResponseDTO getById( int id){
        return repository.findById(id)
                .map(g->new GameResponseDTO(g.getTitle(), g.getGenre(), g.getRating(), g.getReleaseYear()))
                .orElseThrow(()-> new ResourceNotFoundException("not found"));

    }

    public GameResponseDTO addGame(GameRequestDTO gameReDTO){
        Game game = new Game (
                gameReDTO.getGameTitle(),
                gameReDTO.getGameGenre(),
                gameReDTO.getGameRating(),
                gameReDTO.getReleaseYear()
        );

        Game savedGame = repository.save(game);

        GameResponseDTO gameRespDTO = new GameResponseDTO(
                savedGame.getTitle(),
                savedGame.getGenre(),
                savedGame.getRating(),
                savedGame.getReleaseYear());
        return gameRespDTO;
    }


}
