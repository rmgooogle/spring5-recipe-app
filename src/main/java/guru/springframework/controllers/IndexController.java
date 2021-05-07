package guru.springframework.controllers;

import guru.springframework.Services.RecipeService;
import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashSet;
import java.util.Set;


@Controller
public class IndexController {
    private final RecipeService recipeService;


    public IndexController(RecipeService recipeService) {

        this.recipeService = recipeService;

    }

    @RequestMapping({"","/","/index","xyindex"})
    public String getIndexPage(Model model){

        model.addAttribute("recipes", recipeService.getRecipes());
        //model.addAttribute("new",recipeService.getRecipes());

        return "index";
    }



}
