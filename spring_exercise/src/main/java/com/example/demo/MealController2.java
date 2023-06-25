package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class MealController2 {
    List<Meal> mealList = Arrays.asList(new Meal("Pasta in bianco", "Pasta con aglio, olio e peperoncino", 10.00),
            new Meal("Pasta al ragù", "Pasta con ragù di carne", 14.00),
            new Meal("Pasta carbonara", "Pasta con uovo, guanciale, pepe e pecorino", 15.00),
            new Meal("Pasta cacio e pepe", "Pasta con pecorino e pepe", 12.00));

    @GetMapping ("/get/meal")
    public ResponseEntity<List<Meal>> getMeal () {
        return ResponseEntity.ok(mealList);
    }
    @GetMapping ("/get/meal/{mealName}")
    public ResponseEntity<Meal> getMealByName (@PathVariable("mealName") String mealName) {
        Meal selectedMeal = null;
        for (Meal meal: mealList) {
            if (meal.getName().equals(mealName)){
                selectedMeal = meal;
            }
        }
        return ResponseEntity.ok(selectedMeal);
    }
    @GetMapping ("get/meal/description-match/{phrase}")
    public ResponseEntity<List<Meal>> getMealByDescription (@PathVariable("phrase") String partOfDescription) {
        List<Meal> selectedMeals = new ArrayList<>();
        for (Meal meal: mealList) {
            if (meal.getDescription().toLowerCase().contains(partOfDescription.toLowerCase())){
                selectedMeals.add(meal);
            }
        }
        return ResponseEntity.ok(selectedMeals);
    }

    @GetMapping ("get/meal/price")
    public ResponseEntity<List<Meal>> getMealByDescription (@RequestParam("MaxPrice") Double maxPrice, @RequestParam("MinPrice") Double minPrice) {
        List<Meal> selectedMeals = new ArrayList<>();
        for (Meal meal: mealList) {
            if (meal.getPrice() >= minPrice && meal.getPrice() <= maxPrice){
                selectedMeals.add(meal);
            }
        }
        return ResponseEntity.ok(selectedMeals);
    }
}
