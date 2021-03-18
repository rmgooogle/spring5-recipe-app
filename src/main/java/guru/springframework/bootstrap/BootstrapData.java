package guru.springframework.bootstrap;


import guru.springframework.domain.*;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class BootstrapData implements ApplicationListener<ContextRefreshedEvent> {
    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public BootstrapData(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        recipeRepository.saveAll(getRecipes());
    }

    private UnitOfMeasure findUOM(String description){
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription(description);
        if(!unitOfMeasureOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }
        return unitOfMeasureOptional.get();
    }

    private Category findCategory(String description){
        Optional<Category> categoryOptional = categoryRepository.findByDescription(description);
        if(!categoryOptional.isPresent()){
            throw new RuntimeException("Category");
        }
        return categoryOptional.get();
    }

    private List<Recipe> getRecipes(){
        List<Recipe> recipes = new ArrayList<>();


        /*INSERT INTO unit_of_measure (description) VALUES ('Teaspoon');
        INSERT INTO unit_of_measure (description) VALUES ('Tablespoon');
        INSERT INTO unit_of_measure (description) VALUES ('Cup');
        INSERT INTO unit_of_measure (description) VALUES ('Pinch');
        INSERT INTO unit_of_measure (description) VALUES ('Ounce');
        INSERT INTO unit_of_measure (description) VALUES ('Each');
        INSERT INTO unit_of_measure (description) VALUES ('Dash');
        INSERT INTO unit_of_measure (description) VALUES ('Pint');*/
        /*
                Optional<UnitOfMeasure> teaspoonUomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
                if(!teaspoonUomOptional.isPresent()){
                    throw new RuntimeException("Expected UOM Not Found");
                }

                Optional<UnitOfMeasure> tablespoonUomOptional = unitOfMeasureRepository.findByDescription("Tablespoon");
                if(!tablespoonUomOptional.isPresent()){
                    throw new RuntimeException("Expected UOM Not Found");
                }

                Optional<UnitOfMeasure> cupUomOptional = unitOfMeasureRepository.findByDescription("Cup");
                if(!cupUomOptional.isPresent()){
                    throw new RuntimeException("Expected UOM Not Found");
                }

                Optional<UnitOfMeasure> pinchUomOptional = unitOfMeasureRepository.findByDescription("Pinch");
                if(!pinchUomOptional.isPresent()){
                    throw new RuntimeException("Expected UOM Not Found");
                }

                Optional<UnitOfMeasure> ounceUomOptional = unitOfMeasureRepository.findByDescription("Ounce");
                if(!ounceUomOptional.isPresent()){
                    throw new RuntimeException("Expected UOM Not Found");
                }

                Optional<UnitOfMeasure> dashUomOptional = unitOfMeasureRepository.findByDescription("Dash");
                if(!dashUomOptional.isPresent()){
                    throw new RuntimeException("Expected UOM Not Found");
                }

                Optional<UnitOfMeasure> pintUomOptional = unitOfMeasureRepository.findByDescription("Pint");
                if(!pintUomOptional.isPresent()){
                    throw new RuntimeException("Expected UOM Not Found");
                }

                Optional<UnitOfMeasure> eachUomOptional = unitOfMeasureRepository.findByDescription("Each");
                if(!eachUomOptional.isPresent()){
                    throw new RuntimeException("Expected UOM Not Found");
                }*/


        UnitOfMeasure each = findUOM("Each");
        UnitOfMeasure teaspoon = findUOM("Teaspoon");
        UnitOfMeasure tablespoon = findUOM("Tablespoon");
        UnitOfMeasure cup = findUOM("Cup");
        UnitOfMeasure pinch =findUOM("Pinch");
        UnitOfMeasure ounce = findUOM("Ounce");
        UnitOfMeasure dash = findUOM("Dash");
        UnitOfMeasure pint = findUOM("Pint");

        Category americanCategory = findCategory("American");
        Category russianCategory = findCategory("Russian");
        Category kazCategory = findCategory("Kazakhstan");
        Category mexicanCategory = findCategory("Mexican");


        Recipe guacRecipe = new Recipe();
        guacRecipe.setDescription("Perfect Guacamole");
        guacRecipe.setPrepTime(10);
        guacRecipe.setCookTime(0);
        guacRecipe.setDifficulty(Difficulty.EASY);
        guacRecipe.setServings(2);
        guacRecipe.setSource("http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvpiV9Sd");
        guacRecipe.getCategories().add(americanCategory);
        guacRecipe.setDirections("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon" +
                "\n" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)" +
                "\n" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvpiV9Sd");
        Notes guacNotes = new Notes();
        guacNotes.setRecipeNotes("For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries.\n" +
                "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\n" +
                "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvoun5ws");
        guacNotes.setRecipe(guacRecipe);
        guacRecipe.setNotes(guacNotes);

        guacRecipe.getIngredients().add(new Ingredient("ripe avocados", new BigDecimal(2), each, guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("Kosher salt", new BigDecimal(".5"), teaspoon, guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("fresh lime juice or lemon juice", new BigDecimal(2), tablespoon, guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("minced red onion or thinly sliced green onion", new BigDecimal(2), tablespoon, guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("serrano chiles, stems and seeds removed, minced", new BigDecimal(2), each, guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("Cilantro", new BigDecimal(2), tablespoon, guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("freshly grated black pepper", new BigDecimal(2), dash, guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("ripe tomato, seeds and pulp removed, chopped", new BigDecimal(".5"), each, guacRecipe));
        recipes.add(guacRecipe);




        Recipe pizzaRecipe = new Recipe();
        pizzaRecipe.setDescription("Homemade Pizza & Pizza Dough");
        pizzaRecipe.setPrepTime(120);
        pizzaRecipe.setCookTime(30);
        pizzaRecipe.setDifficulty(Difficulty.KIND_OF_HARD);
        pizzaRecipe.setServings(4);
        pizzaRecipe.setSource("https://www.simplyrecipes.com/recipes/homemade_pizza/");
        pizzaRecipe.getCategories().add(mexicanCategory);
        pizzaRecipe.setDirections("1. Proof the yeast\n" +
                "Place the warm water in the large bowl of a heavy duty stand mixer. \n" +
                "Sprinkle the yeast over the warm water and let it sit for 5 minutes\n" +
                " until the yeast is dissolved.\n" +
                "After 5 minutes stir if the yeast hasn't dissolved completely.\n " +
                " The yeast should begin to foam or bloom, indicating that the \n" +
                "yeast is still active and alive.\n" +
                "\n" +
                "(Note that if you are using \"instant yeast\" instead of \"active yeast\", \n" +
                "no proofing is required. Just add to the flour in the next step.)\n");
        Notes pizzaNotes = new Notes();
        pizzaNotes.setRecipeNotes("Pizza dough is a yeasted dough which requires active dry yeast.\n" +
                " Make sure the check the expiration date on the yeast package! \n" +
                "Yeast that is too old may be dead and won't work.\n " +
                "You can use all purpose flour instead of the bread flour that is called for in the recipe,\n " +
                "but bread flour is higher in gluten than all-purpose flour and will make a crispier crust\n " +
                "for your pizza. Cup measurements can vary depending on how you are scooping the flour\n" +
                " (we fluff the flour, lightly scoop it, and level with a knife).\n " +
                "So I recommend using a kitchen scale to measure out the flour amounts by weight.\n " +
                "This is the only way you'll get a consistently accurate measurement.\n");
        pizzaRecipe.setNotes(pizzaNotes);
        pizzaNotes.setRecipe(pizzaRecipe);

        pizzaRecipe.addIngridient(new Ingredient("warm water (105°F-115°F)",new BigDecimal(.5),cup,pizzaRecipe));
        pizzaRecipe.addIngridient((new Ingredient("of active dry yeast",new BigDecimal(.25), teaspoon,pizzaRecipe)));

    recipes.add(pizzaRecipe);
    return recipes;
}


}