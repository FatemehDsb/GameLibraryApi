package com.example.GameLibraryAPI.dto;

import jakarta.validation.constraints.*;


public class GameRequestDTO {
    @NotBlank
    private String gameTitle;
    @NotBlank
    private String gameGenre;
    @Min(1) @Max(10)
    private double gameRating;
    @Min(1950)
    private int releaseYear;


    public GameRequestDTO() {
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
