package com.example.GameLibraryAPI.dto;

public class CategoryRequestDTO {

    private String categoryType;

    public CategoryRequestDTO() {
    }

    public CategoryRequestDTO(String categoryType) {
        this.categoryType = categoryType;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }
}
