package com.example.GameLibraryAPI.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private int categoryId;

private String categoryName;

@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
List<Game> games;

    public Category() {
    }

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
