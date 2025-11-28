package com.example.GameLibraryAPI.repository;

import com.example.GameLibraryAPI.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {

    //select from games where title like %:keyword%
    @Query("SELECT g from Game g where g.title LIKE %:keyword%")
    public List<Game> searchByName (@Param("keyword") String name);

    @Query("SELECT g from Game g where g.rating>= :keyword")
    public List<Game> filterByMinRating (@Param("keyword") double minRating);

    @Query("SELECT g from Game g where g.genre LIKE %:keyword%")
    public List<Game> searchByGenre(@Param("keyword") String genre);


}
