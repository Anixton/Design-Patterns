public class SugarDecorator implements IBeverage{
    IBeverage beverage;

    public SugarDecorator(IBeverage beverage) {
        this.beverage = beverage;
    }

    public int cost() {
        return beverage.cost() + 1;
    }

    public String description() {
        return beverage.description() + (beverage.description().contains("with milk") ? " and sugar" : " with sugar");
    }
}
