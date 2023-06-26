package com.example.demo.Service;

import com.example.demo.DAO.MealDAO;
import com.example.demo.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {
    private MealDAO mealDAO;
    @Autowired
    public MealService(MealDAO mealDAO) {
        this.mealDAO = mealDAO;
    }

    public void addMeal(Meal meal) {
        mealDAO.addMeal(meal);
    }

    public void deleteMeal(String mealName) {
        mealDAO.deleteMeal(mealName);
    }

    public void updateMeal(Meal meal) {
        mealDAO.updateMeal(meal);
    }

    public List<Meal> getMeals() {
        return mealDAO.getMeals();
    }
}
