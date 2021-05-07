package guru.springframework.controllers;

import guru.springframework.Services.RecipeService;
import guru.springframework.domain.Recipe;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class ShowRecipeControllerTest {

    ShowRecipeController showRecipeController;

    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        showRecipeController = new ShowRecipeController(recipeService);
    }

    @Test
    public void getShowPage() throws  Exception{
        Recipe recipe = new Recipe();
        recipe.setId(1L);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(showRecipeController).build();

        Mockito.when(recipeService.findById(anyLong())).thenReturn(recipe);

        mockMvc.perform(get("/recipes/show/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("/recipes/show"));

    }
}