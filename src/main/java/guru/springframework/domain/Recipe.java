package guru.springframework.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = {"notes", "ingredient"})
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;


    @Lob
    private String directions;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients = new HashSet<>();

    @Lob
    private Byte[] image;

    @OneToOne (cascade = CascadeType.ALL)
    private Notes notes;

    @ManyToMany
    @JoinTable(name = "recipe_category_foo",
            joinColumns = @JoinColumn(name ="recipe_id_bar"),
            inverseJoinColumns = @JoinColumn(name = "catogory_id"))
    private Set<Category> categories = new HashSet<>();

    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;


    public void setNotes(Notes notes) {
        this.notes = notes;
        notes.setRecipe(this);
    }

      public Recipe addIngridient(Ingredient ingredient) {
        ingredient.setRecipe(this);
        this.ingredients.add(ingredient);
        return this;

    }
}
