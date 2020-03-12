package rory.springframework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import rory.springframework.services.RecipeService;

/**
 * Created by RS on 6/1/2020.
 */
@Controller
public class IndexController {

    private final RecipeService recipeService;
    public IndexController(RecipeService recipeService) {this.recipeService= recipeService;}

    @RequestMapping({"", "/", "/index"})
    public String listReceipes(Model model) {
        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";

    }
 }
