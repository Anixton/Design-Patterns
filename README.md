# Design-Patterns
 
https://refactoring.guru/design-patterns

https://www.tutorialspoint.com/design_pattern/index.htm

https://github.com/kamranahmedse/design-patterns-for-humans

https://java-design-patterns.com/

https://www.tutorialspoint.com/java_concurrency/index.htm

--------------------------------------------

Single Responsibility Principle: A class should have only one reason to change.

Open/Closed Principle: Software entities (classes,modules,functions) should be open for extension but closed for modification.

Liskov Substitution Principle: Subtypes must be substituable for their base types without altering the correctness of the program.

Interface Segregation Principle: A class should not be forced to implement interfaces it does not use.

Dependency Inversion Principle: High-level modules should not depend on low-level modules. Both should depend on abstractions.

--------------------------------------------

Creational Design Patterns

Singleton: Ensures a class has only one instance and provides a global point of access to it. It's often considered an anti-pattern due to its global state.

Simple Factory: A factory class creates objects of different types based on input arguments. This pattern is not officially recognized as a design pattern but is commonly used.

Factory Method: Defines an interface for creating an object, but lets subclasses decide which class to instantiate.

Abstract Factory: Provides an interface for creating families of related or dependent objects without specifying their concrete classes.

Builder: Separates the construction of a complex object from its representation, allowing the same construction process to create different representations.

Prototype: Specifies the kind of objects to create using a prototypical instance and creates new objects by copying this prototype.

Object Pool: Avoids expensive acquisition and release of resources by recycling objects that are no longer in use. Can be a significant performance boost in some applications.

--------------------------------------------

Structural Design Patterns

Adapter: Allows classes with incompatible interfaces to work together by wrapping its own interface around that of an already existing class.

Bridge: Decouples an abstraction from its implementation so that the two can vary independently.

Composite: Composes zero-or-more similar objects so that they can be manipulated as one object.

Decorator: Dynamically adds/overrides behaviour in an existing method of an object.

Facade: Provides a simplified interface to a large body of code.

Flyweight: Reduces the cost of creating and manipulating a large number of similar objects.

Proxy: Provides a placeholder for another object to control access, reduce cost, and reduce complexity.

--------------------------------------------

Creational Design Patterns


--------------------------------------------
Projelerin başındaki commentları copilotla düzelt bi ara