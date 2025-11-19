package com.example.GameLibraryAPI.dto;

import jakarta.validation.constraints.NotEmpty;
import jdk.jfr.Category;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class GameRequestDTO {
    private String gameTitle;
    @NotEmpty
    private String gameGenre;
    private double gameRating;
    private int releaseYear;

    private Category category;

    public GameRequestDTO() {
    }

    public GameRequestDTO(String gameGenre, double gameRating, int releaseYear) {
        this.gameGenre = gameGenre;
        this.gameRating = gameRating;
        this.releaseYear = releaseYear;
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
