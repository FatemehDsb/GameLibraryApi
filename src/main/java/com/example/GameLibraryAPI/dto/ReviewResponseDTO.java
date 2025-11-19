package com.example.GameLibraryAPI.dto;

public class ReviewResponseDTO {
    private String reviewText;

    public ReviewResponseDTO(String reviewText) {
        this.reviewText = reviewText;
    }

    public ReviewResponseDTO() {
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }
}
