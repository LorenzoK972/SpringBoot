package com.example.TestSpring.Repository;

import com.example.TestSpring.Entity.Ingredient;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface IngredientRepository extends JpaRepository <Ingredient, Long> {
    Optional<Ingredient> findByName(String name);
}
