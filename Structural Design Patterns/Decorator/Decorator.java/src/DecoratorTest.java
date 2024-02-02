import org.junit.*;

public class DecoratorTest {
    @Test
    public void simpleCoffeeShouldHaveCorrectCostAndDescription() {
        Coffee coffee = new Coffee();
        Assert.assertEquals("Coffee : 5", coffee.description() + " : " + coffee.cost());
    }

    @Test
    public void coffeeWithMilkShouldHaveCorrectCostAndDescription() {
        Coffee coffee = new Coffee();
        IBeverage coffeeWithMilkTest = new MilkDecorator(coffee);
        Assert.assertEquals("Coffee with milk : 7", coffeeWithMilkTest.description() + " : " + coffeeWithMilkTest.cost());
    }

    @Test
    public void coffeeWithSugarShouldHaveCorrectCostAndDescription() {
        Coffee coffee = new Coffee();  
        IBeverage coffeeWithSugarTest = new SugarDecorator(coffee);
        Assert.assertEquals("Coffee with sugar : 6", coffeeWithSugarTest.description() + " : " + coffeeWithSugarTest.cost());
    }

    @Test
    public void coffeeWithMilkAndSugarShouldHaveCorrectCostAndDescription() {
        Coffee coffee = new Coffee();  
        IBeverage sugarCoffee = new SugarDecorator(coffee);
        IBeverage coffeeWithMilkAndSugar = new MilkDecorator(sugarCoffee);
        Assert.assertEquals("Coffee with sugar and milk : 8", coffeeWithMilkAndSugar.description() + " : " + coffeeWithMilkAndSugar.cost());
    }
    
    @Test
    public void coffeeWithSugarAndMilkShouldHaveCorrectCostAndDescription() {
        Coffee coffee = new Coffee();  
        IBeverage milkCoffee = new MilkDecorator(coffee);
        IBeverage coffeeWithSugarAndMilk = new SugarDecorator(milkCoffee);
        Assert.assertEquals("Coffee with milk and sugar : 8", coffeeWithSugarAndMilk.description() + " : " + coffeeWithSugarAndMilk.cost());
    }
}
