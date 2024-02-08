public interface RecipeFactory {
    Ingredient createIngredient();
    Recipe createRecipe();
    CookingInstruction createCookingInstruction();
}