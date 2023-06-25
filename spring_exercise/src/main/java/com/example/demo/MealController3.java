package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MealController3 {

    List<Meal> mealList = new ArrayList<>();

    @GetMapping ("/get/meals")
    public ResponseEntity<List<Meal>> getMeal () {
        return ResponseEntity.ok(mealList);
    }
    @PutMapping ("put/meals")
    public ResponseEntity<String> putMeal (@RequestBody Meal meal) {
        this.mealList.add(meal);
        return ResponseEntity.ok("Meal added!");
    }

    @PostMapping ("post/meals/{mealName}")
    public ResponseEntity<String> postMeal (@PathVariable ("mealName") String mealName, @RequestBody Meal updatedMeal) {
        this.mealList.removeIf(meal -> meal.getName().equals(mealName));
        this.mealList.add(updatedMeal);
        return ResponseEntity.ok("Meal updated!");
    }
    @DeleteMapping ("delete/meals/{mealName}")
    public ResponseEntity<String> deleteMealByName (@PathVariable ("mealName") String mealName) {
        this.mealList.removeIf(meal -> meal.getName().equals(mealName));
        return ResponseEntity.ok("Meal deleted!");
    }
    @DeleteMapping ("delete/meals/price/{mealPrice}")
    public ResponseEntity<String> deleteMealByPrice (@PathVariable ("mealPrice") Double mealPrice) {
        this.mealList.removeIf(meal -> meal.getPrice() > mealPrice);
        return ResponseEntity.ok("Meal list updated!");
    }

    @PutMapping ("put/meals/{mealName}/price")
    public ResponseEntity<String> putMealByPrice (@PathVariable ("mealName") String mealName, @RequestBody Meal updatedMeal) {

        Meal mealToUpdate = mealList.stream().filter(meal -> meal.getName().equals(mealName)).findFirst().get();
        mealToUpdate.setPrice(updatedMeal.getPrice());
        return ResponseEntity.ok("Meal's price updated!");
    }
}
