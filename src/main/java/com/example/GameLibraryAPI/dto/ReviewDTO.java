package com.example.GameLibraryAPI.dto;

import jakarta.validation.constraints.NotBlank;

public class ReviewDTO {
    @NotBlank
    private String text;
    private int gameId;

    public ReviewDTO() {
    }

    public ReviewDTO(String text, int gameId) {
        this.text = text;
        this.gameId = gameId;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }
}
