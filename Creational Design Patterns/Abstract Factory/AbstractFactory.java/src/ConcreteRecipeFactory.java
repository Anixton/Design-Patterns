import java.util.Random;

public class ConcreteRecipeFactory implements RecipeFactory {
    @Override
    public Ingredient createIngredient() {
        // Creating a random ingredient (Flour or Eggs) for illustration purposes
        int randomIngredient = new Random().nextInt(2);
        if (randomIngredient == 0) {
            return new Flour();
        } else {
            return new Eggs();
        }
    }

    @Override
    public Recipe createRecipe() {
        // Creating a random recipe (Cake or Cookies) for illustration purposes
        int randomRecipe = new Random().nextInt(2);
        if (randomRecipe == 0) {
            return new CakeRecipe();
        } else {
            return new CookieRecipe();
        }
    }

    @Override
    public CookingInstruction createCookingInstruction() {
        // Let's create a random cooking instruction (Baking or Frying) for illustration purposes
        int randomInstruction = new Random().nextInt(2);
        if (randomInstruction == 0) {
            return new BakingInstruction();
        } else {
            return new FryingInstruction();
        }
    }
}