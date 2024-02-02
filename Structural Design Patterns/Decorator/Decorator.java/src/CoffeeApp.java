//*******************************************************************************************
//*  Hakan Gezginci
//* 
//*  This application demonstrates the Decorator design pattern, allowing the dynamic
//*  addition of new functionalities to a base object without altering its structure.
//*  The primary components of the application include a base interface (IBeverage),
//*  concrete implementation (Coffee), and decorator classes (MilkDecorator, SugarDecorator).
//*******************************************************************************************

/**
* 
*  Coffee Shop Application
*
*  The IBeverage interface defines the abstraction for different beverage types, requiring
*  methods for retrieving the cost and description of the beverage. The Coffee class
*  serves as a concrete implementation of the Beverage interface, representing a basic
*  coffee without any additional features.
*
*  The MilkDecorator and SugarDecorator classes act as decorators, extending the behavior
*  of the base IBeverage interface by adding the cost and description of milk and sugar.
*  These decorators allow the composition of various combinations of ingredients to create
*  different types of coffee.
*
*  The main method in CoffeeApp class showcases the usage of the Decorator pattern.
*  It creates instances of basic coffee and decorators, then combines them to create
*  different coffee variations with additional ingredients. The tests ensure that the
*  cost and description of each coffee variant are calculated correctly.
*
*  Components:
*  - Base Interface: IBeverage
*  - Concrete Implementation: Coffee
*  - Decorators: MilkDecorator, SugarDecorator
*  - Client Code: CoffeeApp
*
*  The application provides a flexible and extensible structure, allowing the addition
*  of new decorators to introduce new ingredients or modifications to existing beverages
*  without altering the original code. This promotes code maintainability and scalability
*  in a coffee shop system.
*/


public class CoffeeApp {
    public static void main(String[] args) throws Exception {
        Coffee coffee = new Coffee();
        System.out.println(coffee.description() + " : " + coffee.cost());

        IBeverage milkCoffee = new MilkDecorator(coffee);
        System.out.println(milkCoffee.description() + " : " + milkCoffee.cost());

        IBeverage sugarMilkCoffee = new SugarDecorator(milkCoffee);
        System.out.println(sugarMilkCoffee.description() + " : " + sugarMilkCoffee.cost());
    }
}
