package com.example.GameLibraryAPI.service;

import com.example.GameLibraryAPI.dto.GameRequestDTO;
import com.example.GameLibraryAPI.dto.GameResponseDTO;
import com.example.GameLibraryAPI.dto.ReviewDTO;
import com.example.GameLibraryAPI.entity.Game;
import com.example.GameLibraryAPI.entity.Review;
import com.example.GameLibraryAPI.exception.ResourceNotFoundException;
import com.example.GameLibraryAPI.repository.GameRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class GameService {

    private GameRepository repository;

    public GameService(GameRepository repository){
        this.repository = repository;
    }

    public List<GameResponseDTO> getAll(){
        return repository.findAll()
                .stream()
                .map(g ->{
                        List<ReviewDTO> reviewDTOS =
                                g.getReviews()
                                        .stream()
                                        .map(r -> new ReviewDTO(r.getText(), r.getId()))
                                        .toList();

            return new
                    GameResponseDTO( g.getTitle(),g.getGenre(), g.getRating(), g.getReleaseYear(), reviewDTOS);
                }
            ).toList();
    }

    public Page<GameResponseDTO> getAllGamesPage(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return  repository.findAll(pageable)
                .map(g-> new GameResponseDTO(g.getTitle(), g.getGenre(), g.getRating(), g.getReleaseYear()));
    }

    public GameResponseDTO getById( int id){
        return repository.findById(id)
                .map(g->new GameResponseDTO(g.getTitle(), g.getGenre(), g.getRating(), g.getReleaseYear()))
                .orElseThrow(()-> new ResourceNotFoundException("This game is not found"));
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

    public List<GameResponseDTO> searchByName(String name) {
        return repository.searchByName(name)
                .stream()
                .map(g-> new GameResponseDTO(g.getTitle(), g.getGenre(), g.getRating(), g.getReleaseYear()))
                .toList();
    }


    public List<GameResponseDTO> findByMinRating(double minRating){
        return repository.filterByMinRating(minRating)
                .stream()
                .map(g-> new GameResponseDTO(g.getTitle(), g.getGenre(), g.getRating(), g.getReleaseYear()))
                .toList();
    }


    public List<GameResponseDTO> searchByGenre(String genre){
        return repository.searchByGenre(genre)
                .stream()
                .map(g -> new GameResponseDTO(g.getTitle(), g.getGenre(), g.getRating(), g.getReleaseYear()))
                .toList();
    }

    public String generateSummery(int id){
        Game game = repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("This game is not found"));;
        return
                ("The Game name is : " + game.getTitle() + " ," + " and this games genre is : " + game.getGenre()  + " ." +
                        "Game's rating is  : " + game.getRating() + " "
                + "And it  was released at : " + game.getReleaseYear());
    }








}
