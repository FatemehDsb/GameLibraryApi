//package com.example.GameLibraryAPI.entity;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name= "reviews")
//public class Review {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int reviewId;
//
//    @ManyToOne
//    @JoinColumn(name="game_id")
//    private Game game;
//
//    @ManyToOne
//    @JoinColumn(name="category_id")
//    private Category category;
//
//
//
//    private String reviewText;
//
//    public Review(String reviewText) {
//        this.reviewText = reviewText;
//    }
//
//    public Review() {
//    }
//
//    public int getReviewId() {
//        return reviewId;
//    }
//
//    public void setReviewId(int reviewId) {
//        this.reviewId = reviewId;
//    }
//
//    public String getReviewText() {
//        return reviewText;
//    }
//
//    public void setReviewText(String reviewText) {
//        this.reviewText = reviewText;
//    }
//}
