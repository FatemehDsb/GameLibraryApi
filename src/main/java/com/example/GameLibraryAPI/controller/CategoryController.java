package com.example.GameLibraryAPI.controller;

import com.example.GameLibraryAPI.dto.CategoryResponseDTO;
import com.example.GameLibraryAPI.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service){
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

}
