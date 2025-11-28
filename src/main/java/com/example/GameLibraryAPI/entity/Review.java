package com.example.GameLibraryAPI.entity;

import jakarta.persistence.*;

import java.util.Optional;


@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String text;

    @ManyToOne
    @JoinColumn(name="game_id")
    private Game game;

    public Review() {
    }

    public Review(String text, Game game) {
        this.text = text;
        this.game = game;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
