package rory.springframework.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import rory.springframework.domain.*;
import rory.springframework.repositories.CategoryRepository;
import rory.springframework.repositories.RecipeRepository;
import rory.springframework.repositories.UnitOfMeasureRepository;

import java.math.BigDecimal;
import java.util.Optional;

@Component
public class RecipeBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private CategoryRepository categoryRepository;
    private RecipeRepository recipeRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeBootStrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {


        Optional<UnitOfMeasure> uomCupOptional = unitOfMeasureRepository.findByDescription("Cup");
        if(!uomCupOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found");
        }
        UnitOfMeasure uomCup = uomCupOptional.get();


        Recipe guacamole = new Recipe();
        guacamole.setPrepTime(10);
        guacamole.setServings(4);
        guacamole.setCookTime(20);
        guacamole.setSource("simplyrecipes.com");
        guacamole.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");

        guacamole.setDirections("1 Cut the avocado, remove flesh: Cut the avocados in half. Remove the pit. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.\n" +
        "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\n" +
        "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
        "4 Serve: Serve immediately, or if making a few hours ahead, place plastic wrap on the surface of the guacamole and press down to cover it and to prevent air reaching it. ");
 //       guacamole.setDirections("1 Cut the avocado, remove flesh: Cut the avocados in half. Remove the pit. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.\n");

        guacamole.setDifficulty(Difficulty.EASY);
        Notes guacNotes = new Notes();
        guacNotes.setRecipeNotes("The word “guacamole”, and the dip, are both originally from Mexico, where avocados have been cultivated for thousands of years. The name is derived from two Aztec Nahuatl words—ahuacatl (avocado) and molli (sauce).");
        guacNotes.setRecipe(guacamole);
        guacamole.setNotes(guacNotes);

        // Optional<Category> guacCategory = categoryRepository.findByDescription("Mexican");
        // Category guacCategory = categoryRepository.findByDescription("Mexican");

        guacamole.getIngredients().add(new Ingredient("ripe avocados",new BigDecimal(2)));
        guacamole.getIngredients().add(new Ingredient("tortilla chips",new BigDecimal(1)));

 /*       Set<Ingredient> ingredientSet = new HashSet<Ingredient>();
        Ingredient ingredient = new Ingredient();
        ingredient.setDescription("ripe avocados");
        ingredient.setAmount(new BigDecimal("2"));
        ingredientSet.add(ingredient);
        guacamole.setIngredients(ingredientSet);
*/

        recipeRepository.save(guacamole);


        System.out.println(guacamole.getPrepTime().toString());
        System.out.println(guacamole.getNotes().getRecipeNotes());
        System.out.println(uomCup.getDescription());
        for (Ingredient temp :  guacamole.getIngredients()) {
            System.out.println(temp.getDescription());
        }

    }
}




