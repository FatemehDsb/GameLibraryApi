package com.example.GameLibraryAPI.service;

import com.example.GameLibraryAPI.dto.ReviewDTO;
import com.example.GameLibraryAPI.entity.Game;
import com.example.GameLibraryAPI.entity.Review;
import com.example.GameLibraryAPI.repository.GameRepository;
import com.example.GameLibraryAPI.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final GameRepository gameRepository;

    public ReviewService(ReviewRepository reviewRepository, GameRepository gameRepository){
        this.reviewRepository = reviewRepository;
        this.gameRepository = gameRepository;
    }

    public ReviewDTO addReview ( ReviewDTO reviewDTO){
        Optional<Game> optionalGame  = gameRepository.findById(reviewDTO.getGameId());
        Game game = optionalGame.orElseThrow(() -> new RuntimeException("Game not found"));
        Review review = new Review();
        review.setText(reviewDTO.getText());
        review.setGame(game);
        Review savedReview = reviewRepository.save(review);
        return new ReviewDTO(
              savedReview.getText(),
              savedReview.getGame().getId()
        );
    }

    public List<ReviewDTO> getAll(){
        List<Review> reviews = reviewRepository.findAll();
        return reviews.stream()
                        .map(r-> new ReviewDTO(r.getText(), r.getGame().getId()))
                        .toList();
    }





}
