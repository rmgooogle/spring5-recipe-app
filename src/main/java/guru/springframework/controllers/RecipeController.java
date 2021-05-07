package guru.springframework.controllers;

import guru.springframework.Services.RecipeService;
import guru.springframework.commands.RecipeCommand;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RecipeController {



    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("recipes/new")
    public String viewRecipe(Model model){
        model.addAttribute("recipe", new RecipeCommand());
        return "recipes/recipeform";
    }

    @PostMapping
    @RequestMapping("recipe")
    public String saveOrUpdate (@ModelAttribute RecipeCommand command){
        RecipeCommand savedCommand = recipeService.saveRecipeCommand(command);
        return "redirect:/recipes/show/" + savedCommand.getId();
    }
}
