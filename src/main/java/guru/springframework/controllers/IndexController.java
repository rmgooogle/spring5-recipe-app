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


@Controller
public class IndexController {
    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {

        this.recipeService = recipeService;
    }

    @RequestMapping({"","/","/index","xyindex"})
    public String getIndexPage(Model model){

        model.addAttribute("recipes", recipeService.getRecipes());
        model.addAttribute("new",recipeService.getRecipes());

        return "index";
    }
}
