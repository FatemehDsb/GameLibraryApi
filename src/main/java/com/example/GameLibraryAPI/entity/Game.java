package com.example.GameLibraryAPI.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String genre;
    private double rating;
    private int releaseYear;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
    private List<Review> reviews;

    public Game() {
    }

    public Game(String title, String genre, double rating, int releaseYear) {
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.releaseYear = releaseYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int  releaseYear) {
        this.releaseYear = releaseYear;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
