package com.example.GameLibraryAPI.dto;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class GameResponseDTO {
    @NotBlank
    private String gameTitle;

    private String gameGenre;

    @Min(1) @Max(10)
    private double gameRating;
    @Min(1950)
    private int releaseYear;

    public GameResponseDTO() {
    }
    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public GameResponseDTO(String gameTitle,String gameGenre, double gameRating, int releaseYear) {
        this.gameGenre = gameGenre;
        this.gameRating = gameRating;
        this.releaseYear = releaseYear;
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
