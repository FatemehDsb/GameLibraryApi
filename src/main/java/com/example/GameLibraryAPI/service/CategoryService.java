package com.example.GameLibraryAPI.service;

import com.example.GameLibraryAPI.dto.CategoryResponseDTO;
import com.example.GameLibraryAPI.entity.Category;
import com.example.GameLibraryAPI.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

   private final CategoryRepository repository;

   public CategoryService(CategoryRepository repository){
       this.repository = repository;
   }

   public List<CategoryResponseDTO> getAll(){

       List<Category> categories = repository.findAll();
       return categories
               .stream()
               .map(c-> new CategoryResponseDTO(c.getCategoryName()))
               .toList();
   }
}
