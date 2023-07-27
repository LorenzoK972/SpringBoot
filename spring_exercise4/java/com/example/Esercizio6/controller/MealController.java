package com.example.Esercizio6.controller;

import com.example.Esercizio6.entities.Dto.CreateMealRequestDto;
import com.example.Esercizio6.entities.Dto.CreateMealResponseDto;
import com.example.Esercizio6.entities.Dto.GetMealResponseDto;
import com.example.Esercizio6.service.MealService;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


    @RestController
    public class MealController {

        @Autowired
        private MealService mealService;

        @PostMapping("/meal/create")
        public CreateMealResponseDto createMeal(@RequestBody CreateMealRequestDto request) {
            return mealService.createMeal(request);
        }

        @GetMapping("meal/getWintermeal")
        public List<GetMealResponseDto> getWintermeals () throws UnirestException {
         return mealService.winterMeal();
        }

    }

