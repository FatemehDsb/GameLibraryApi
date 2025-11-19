package com.example.GameLibraryAPI.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

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

    public Game(int releaseYear, double rating, String genre, String title) {
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.genre = genre;
        this.title = title;
    }

    public Game() {
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
}
