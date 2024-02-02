public class MilkDecorator implements IBeverage{
    IBeverage beverage;

    public MilkDecorator(IBeverage beverage) {
        this.beverage = beverage;
    }

    public int cost() {
        return beverage.cost() + 2;
    }

    public String description() {
        return beverage.description() + (beverage.description().contains("with sugar") ? " and milk" : " with milk");
    }
}
