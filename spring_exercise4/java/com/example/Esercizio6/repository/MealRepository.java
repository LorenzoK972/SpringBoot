package com.example.Esercizio6.repository;

import com.example.Esercizio6.entities.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MealRepository extends JpaRepository<Meal, String> {

    Optional<Meal> findByName(String username);
}
