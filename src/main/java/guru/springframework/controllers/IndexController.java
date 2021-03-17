package guru.springframework.controllers;

import guru.springframework.Services.RecipeService;
import guru.springframework.domain.Category;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
public class IndexController {
    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {

        this.recipeService = recipeService;
    }

    @RequestMapping({"","/","/index","xyindex"})
    public String getIndexPage(HttpServletRequest request, Model model){

        String welcomeMessage = "now in ";
        model.addAttribute("message",  request.getRequestURL().toString() );
        model.addAttribute("message2", welcomeMessage + request.getRequestURI());


        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }
}
