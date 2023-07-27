package com.example.Esercizio6.entities;

import jakarta.persistence.*;

@Entity
@Table
public class Meal {

    @Id
    private String name;
    private String ingredient;
    private Boolean isCool;


    public Meal(String name, String ingredient, Boolean isCool) {
        this.name = name;
        this.ingredient = ingredient;
        this.isCool = isCool;
    }

    public Meal() {
    }

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
