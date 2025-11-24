package com.example.GameLibraryAPI.dto;

import jakarta.validation.constraints.NotEmpty;
import com.example.GameLibraryAPI.entity.Category;



public class GameRequestDTO {
    @NotEmpty
    private String gameTitle;
    private String gameGenre;
    private double gameRating;
    private int releaseYear;

    private Category category;

    public GameRequestDTO() {
    }

    public GameRequestDTO(String gameTitle, String gameGenre, double gameRating, int releaseYear) {
        this.gameTitle = gameTitle;
        this.gameGenre = gameGenre;
        this.gameRating = gameRating;
        this.releaseYear = releaseYear;
    }

    public GameRequestDTO(String gameGenre, double gameRating, int releaseYear) {
        this.gameGenre = gameGenre;
        this.gameRating = gameRating;
        this.releaseYear = releaseYear;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public String getGameGenre() {
        return gameGenre;
    }

    public void setGameGenre(String gameGenre) {
        this.gameGenre = gameGenre;
    }

    public double getGameRating() {
        return gameRating;
    }

    public void setGameRating(double gameRating) {
        this.gameRating = gameRating;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
}
