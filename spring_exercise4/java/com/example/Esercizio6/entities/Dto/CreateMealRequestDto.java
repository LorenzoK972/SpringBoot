package com.example.Esercizio6.entities.Dto;

public class CreateMealRequestDto {

    private String name;
    private String ingredient;
    private Boolean isCool;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public Boolean getCool() {
        return isCool;
    }

    public void setCool(Boolean cool) {
        isCool = cool;
    }
}
