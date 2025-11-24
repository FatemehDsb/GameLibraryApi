package com.example.GameLibraryAPI.repository;

import com.example.GameLibraryAPI.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
