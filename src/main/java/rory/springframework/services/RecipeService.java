package rory.springframework.services;

import rory.springframework.domain.Recipe;

import java.util.Set;

public interface RecipeService  {
    public Set<Recipe> getRecipes();
}

