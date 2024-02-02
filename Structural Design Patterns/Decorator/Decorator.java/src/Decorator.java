public class Decorator {
    public static void main(String[] args) throws Exception {
        Coffee coffee = new Coffee();
        System.out.println(coffee.description() + " : " + coffee.cost());

        IBeverage milkCoffee = new MilkDecorator(coffee);
        System.out.println(milkCoffee.description() + " : " + milkCoffee.cost());

        IBeverage sugarMilkCoffee = new SugarDecorator(milkCoffee);
        System.out.println(sugarMilkCoffee.description() + " : " + sugarMilkCoffee.cost());
    }
}
