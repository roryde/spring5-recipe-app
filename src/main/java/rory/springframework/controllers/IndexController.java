package rory.springframework.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import rory.springframework.services.RecipeService;

/**
 * Created by RS on 6/1/2020.
 */
@Slf4j
@Controller
public class IndexController {

    private final RecipeService recipeService;
    public IndexController(RecipeService recipeService) {this.recipeService= recipeService;}

    @RequestMapping({"", "/", "/index"})
    public String listReceipes(Model model) {
        log.debug("model controller");
        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";

    }
 }
