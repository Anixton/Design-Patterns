public class BakingInstruction implements CookingInstruction {
    @Override
    public void execute(Recipe recipe) {
        System.out.println("Baking the " + recipe.getName());
    }
}