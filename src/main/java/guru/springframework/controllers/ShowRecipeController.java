package guru.springframework.controllers;

import guru.springframework.Services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class ShowRecipeController {
    private final RecipeService recipeService;

    public ShowRecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping(value = "/recipes/show/{id}", method = RequestMethod.GET)
    public String getShowPage(@PathVariable("id") long id, Model model){
        model.addAttribute("recipe", recipeService.findById(id));
        return "/recipes/show";
    }
}
