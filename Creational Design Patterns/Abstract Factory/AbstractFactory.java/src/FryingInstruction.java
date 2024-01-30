class FryingInstruction implements CookingInstruction {
    @Override
    public void execute(Recipe recipe) {
        System.out.println("Frying the " + recipe.getName());
    }
}