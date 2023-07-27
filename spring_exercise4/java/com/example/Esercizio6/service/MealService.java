package com.example.Esercizio6.service;

import com.example.Esercizio6.entities.Dto.CreateMealRequestDto;
import com.example.Esercizio6.entities.Dto.CreateMealResponseDto;
import com.example.Esercizio6.entities.Dto.GetMealResponseDto;
import com.example.Esercizio6.entities.Meal;
import com.example.Esercizio6.repository.MealRepository;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
    public class MealService {

        @Autowired
        private MealRepository mealRepository;
        public CreateMealResponseDto createMeal(CreateMealRequestDto request) {

            Optional<Meal> oMeal = mealRepository.findByName(request.getName());
            if(oMeal.isPresent()){
                throw  new RuntimeException();}
            Meal meal = new Meal();
            meal.setName(request.getName());
            meal.setIngredient(request.getIngredient());
            meal.setCool(request.getCool());
            meal= mealRepository.save(meal);

            CreateMealResponseDto newMeal = new CreateMealResponseDto();
            newMeal.setName(meal.getName());
            return newMeal ;
        }


        public List<GetMealResponseDto> winterMeal() throws UnirestException {
            List<Meal> mealList = getWinterMeal();

            List<GetMealResponseDto> mealResponseDtos = new ArrayList<>();
            for (Meal meal : mealList){
                GetMealResponseDto mealResponseDto = new GetMealResponseDto();
                mealResponseDto.setName(meal.getName());
                mealResponseDto.setIngredient(meal.getIngredient());
                mealResponseDtos.add(mealResponseDto);
            }
            return mealResponseDtos;
        }

        public List<Meal> getWinterMeal() throws UnirestException {

            JSONObject response= Unirest.get("https://open-meteo.com/en/docs#latitude=41.8919&longitude=12.5113")
                    .asJson().getBody().getObject();
            List<Meal> winterMeal= new ArrayList<>();
            Double temp = response.getJSONObject("current weather").getDouble("temperature");
            if (temp<28){
                winterMeal = mealRepository.findAll().stream().filter(Meal::getCool).collect(Collectors.toList());
                }
            return winterMeal;

        }




    }

