package com.example.TestSpring.Service;

import com.example.TestSpring.DTO.*;
import com.example.TestSpring.Entity.Ingredient;
import com.example.TestSpring.Repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IngredientService {
    @Autowired
    private IngredientRepository ingredientRepository;

    public CreateResponseDTO createIngredient (CreateRequestDTO requestDTO) {
        Optional<Ingredient> oIngredient = ingredientRepository.findByName(requestDTO.getName());
        if (oIngredient.isPresent()) {
            throw new RuntimeException();
        }
        Ingredient ingredient = new Ingredient();
        ingredient.setName(requestDTO.getName());
        ingredient.setVegan(requestDTO.isVegan());
        ingredient.setGlutenFree(requestDTO.isGlutenFree());
        ingredient.setVegetarian(requestDTO.isVegetarian());
        ingredient.setLactoseFree(requestDTO.isLactoseFree());
        ingredientRepository.save(ingredient);
        CreateResponseDTO responseDTO = new CreateResponseDTO();
        responseDTO.setId(ingredient.getId());
        return responseDTO;
    }

    public GetResponseDTO getIngredient (Long id) {
        Optional<Ingredient> oIngredient = ingredientRepository.findById(id);
        if (oIngredient.isEmpty()) {
            throw new RuntimeException();
        }
        Ingredient ingredient = new Ingredient();
        GetResponseDTO responseDTO = new GetResponseDTO();
        responseDTO.setId(ingredient.getId());
        responseDTO.setName(ingredient.getName());
        responseDTO.setVegan(ingredient.isVegan());
        responseDTO.setVegetarian(ingredient.isVegetarian());
        responseDTO.setLactoseFree(ingredient.isLactoseFree());
        responseDTO.setGlutenFree(ingredient.isGlutenFree());
        return responseDTO;
    }

    public BaseResponse updateIngredient (UpdateRequestDTO requestDTO) {
        Optional<Ingredient> oIngredient = ingredientRepository.findById(requestDTO.getId());
        if (oIngredient.isEmpty()) {
            throw new RuntimeException();
        }
        Ingredient ingredient = oIngredient.get();
        ingredient.setName(requestDTO.getName());
        ingredient.setName(requestDTO.getName());
        ingredient.setVegan(requestDTO.isVegan());
        ingredient.setGlutenFree(requestDTO.isGlutenFree());
        ingredient.setVegetarian(requestDTO.isVegetarian());
        ingredient.setLactoseFree(requestDTO.isLactoseFree());
        ingredientRepository.save(ingredient);
        return new BaseResponse();
    }

    public BaseResponse deleteIngredient (DeleteRequestDTO requestDTO) {
        Optional<Ingredient> oIngredient = ingredientRepository.findById(requestDTO.getId());
        if (oIngredient.isEmpty()) {
            throw new RuntimeException();
        }
        Ingredient ingredient = oIngredient.get();
        ingredientRepository.delete(ingredient);
        return new BaseResponse();
    }
}
