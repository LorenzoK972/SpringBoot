package com.example.demo.DAO;

import com.example.demo.Meal;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MealDAO {
    List<Meal> mealList = new ArrayList<>();

    public void addMeal(Meal meal) {
        this.mealList.add(meal);
    }

    public void deleteMeal(String mealName) {
        this.mealList.removeIf(meal -> meal.getName().equals(mealName));
    }

    public void updateMeal(Meal meal) {
        this.mealList.removeIf(m -> m.getName().equals(meal.getName()));
        this.mealList.add(meal);
    }

    public List<Meal> getMeals() {
        return this.mealList;
    }
}
