package com.example.jpa.repository;

import com.example.jpa.model.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClassesRepository extends JpaRepository<Classes,Integer> {
    @Query("select c from Classes c where c.name = ?1")
    Optional<Classes> findByClassName(String name);

}
