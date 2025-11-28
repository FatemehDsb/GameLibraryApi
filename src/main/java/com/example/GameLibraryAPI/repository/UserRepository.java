package com.example.GameLibraryAPI.repository;

import com.example.GameLibraryAPI.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUser, Long> {
public Optional<AppUser> findByUsername(String username);

}
