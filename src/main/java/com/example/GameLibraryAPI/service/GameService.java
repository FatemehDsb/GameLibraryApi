package com.example.GameLibraryAPI.service;

import com.example.GameLibraryAPI.dto.GameResponseDTO;
import com.example.GameLibraryAPI.entity.Game;
import com.example.GameLibraryAPI.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

//    public GameResponseDTO toDto(List<Game> games){
//       return  games.stream()
//                .map(g-> g.getReleaseYear(), g.getRating(), g.getTitle(), g.getRating())
//                .toList();
//
//    }
}
