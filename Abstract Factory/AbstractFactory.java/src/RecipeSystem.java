/**
 * This is the main client code for the Recipe Management System.
 * It demonstrates the use of the abstract factory design pattern to create and interact with
 * ingredients, recipes, and cooking instructions.
 *
 * The program includes the following components:
 * - Ingredients: Flour, Sugar, Eggs (not used in this example)
 * - Units of Measurement: Grams, Cups (not used in this example)
 * - Recipes: CakeRecipe, CookieRecipe
 * - Cooking Instructions: BakingInstruction, FryingInstruction
 *
 * The Abstract Factory (RecipeFactory) provides an interface for creating families of related
 * or dependent objects, allowing the client code to create concrete instances without specifying
 * their actual classes.
 *
 * The ConcreteRecipeFactory implements the RecipeFactory interface and creates random instances
 * of ingredients, recipes, and cooking instructions for illustration purposes.
 *
 * The client code then prints information about the created ingredient, recipe, and executes
 * the corresponding cooking instruction.
 *
  //*********************************************************************************
  //*  Author: Hakan Gezginci
  //* 
  //*  This program uses the abstract factory design pattern to manage recipes.
  //*  It creates instances of ingredients, recipes, and cooking instructions through
  //*  the RecipeFactory interface, demonstrating the flexibility of the pattern.
  //*********************************************************************************
 */

public class RecipeSystem {
    public static void main(String[] args) {

        RecipeFactory factory = new ConcreteRecipeFactory();

        Ingredient ingredient = factory.createIngredient();
        Recipe recipe = factory.createRecipe();
        CookingInstruction cookingInstruction = factory.createCookingInstruction();

        System.out.println("Ingredient: " + ingredient.getName());
        System.out.println("Recipe: " + recipe.getName());
        cookingInstruction.execute(recipe);
    }
}