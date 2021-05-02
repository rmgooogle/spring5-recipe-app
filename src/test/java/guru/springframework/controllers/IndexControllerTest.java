package guru.springframework.controllers;

import guru.springframework.Services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.matchers.Any;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


public class IndexControllerTest {

    IndexController indexController;

    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        indexController = new IndexController(recipeService);
    }



    @Test
    public void getIndexPage() {
    String viewName = indexController.getIndexPage(model);

    assertEquals(viewName,"index");
    verify(model,times(1)).addAttribute(eq("recipes"), anySet());
    verify(model,times(1)).addAttribute(eq("new"), anySet());
    verify(recipeService,times(2)).getRecipes();

    }
}