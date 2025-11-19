package com.example.GameLibraryAPI.dto;

public class CategoryResponseDTO {

    private String categoryType;

    public CategoryResponseDTO() {
    }

    public CategoryResponseDTO(String categoryType) {
        this.categoryType = categoryType;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }
}
