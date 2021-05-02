package guru.springframework.Services;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import org.junit.Before;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class RecipeServiceImpTest {

    RecipeServiceImp recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImp(recipeRepository);
    }

    @Test
    public void getRecipes() {

        Recipe recipe = new Recipe();
        recipe.setDescription("123qwe");
        Recipe recipe2 = new Recipe();
        recipe2.setDescription("456asd");

        HashSet recipeData = new HashSet();
        recipeData.add(recipe);
        recipeData.add(recipe2);

        System.out.println(recipeData);

        Mockito.when(recipeRepository.findAll()).thenReturn(recipeData);

        Set<Recipe> recipes = recipeService.getRecipes();
        System.out.println(recipeData.size()+ " size");
        assertEquals(recipes.size(), 2);
        Mockito.verify(recipeRepository, Mockito.times(1)).findAll();
    }
}