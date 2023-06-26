package com.example.demo.Controller;

import com.example.demo.Meal;
import com.example.demo.Service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MealController {
    private MealService mealService;
    @Autowired
    public MealController (MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping ("/get/meals")
    public ResponseEntity<List<Meal>> getMeal () {
        return ResponseEntity.ok(mealService.getMeals());
    }
    @PutMapping ("put/meals")
    public ResponseEntity<String> putMeal (@RequestBody Meal meal) {
        mealService.addMeal(meal);
        return ResponseEntity.ok("Meal added!");
    }

    @PostMapping ("post/meals/update-meal")
    public ResponseEntity<String> postMeal (@RequestBody Meal updatedMeal) {
        mealService.updateMeal(updatedMeal);
        return ResponseEntity.ok("Meal updated!");
    }
    @DeleteMapping ("delete/meals/{mealName}")
    public ResponseEntity<String> deleteMealByName (@PathVariable ("mealName") String mealName) {
        mealService.deleteMeal(mealName);
        return ResponseEntity.ok("Meal deleted!");
    }
}
