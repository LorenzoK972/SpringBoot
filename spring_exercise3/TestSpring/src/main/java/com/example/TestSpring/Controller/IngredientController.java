package com.example.TestSpring.Controller;


import com.example.TestSpring.DTO.*;
import com.example.TestSpring.Service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class IngredientController {
    @Autowired
    private IngredientService ingredientService;
    @PostMapping("ingredient/post")
    public CreateResponseDTO createIngredient (@RequestBody CreateRequestDTO requestDTO) {
        return ingredientService.createIngredient(requestDTO);
    }
    @GetMapping("ingredient/get")
    public GetResponseDTO getIngredient (@RequestParam Long id) {
        return  ingredientService.getIngredient(id);
    }
    @PutMapping ("ingredient/put")
    public BaseResponse updateIngredient (@RequestBody UpdateRequestDTO requestDTO) {
        return ingredientService.updateIngredient(requestDTO);
    }
    @DeleteMapping ("ingredient/delete")
    public BaseResponse deleteIngredient (@RequestBody DeleteRequestDTO requestDTO) {
        return ingredientService.deleteIngredient(requestDTO);
    }
}
