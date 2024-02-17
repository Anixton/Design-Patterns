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
Behavioral Design Patterns

Strategy: Defines a family of algorithms, encapsulates each one, and makes them interchangeable. Strategy lets the algorithm vary independently from clients that use it.

Observer: Defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.

Command: Encapsulates a request as an object, thereby letting you parameterize clients with queues, requests, and operations.

State: Allows an object to alter its behavior when its internal state changes. The object will appear to change its class.

Chain of Responsibility: Avoids coupling the sender of a request to its receiver by giving more than one object a chance to handle the request.

Visitor: Represents an operation to be performed on the elements of an object structure without changing the classes on which it operates.

Mediator: Defines an object that encapsulates how a set of objects interact.

Memento: Without violating encapsulation, capture and externalize an object's internal state so that the object can be restored to this state later.

Interpreter: Given a language, define a representation for its grammar along with an interpreter that uses the representation to interpret sentences in the language.

Template Method: Defines the skeleton of an algorithm in an operation, deferring some steps to subclasses.

Iterator: Provides a way to access the elements of an aggregate object sequentially without exposing its underlying representation.

--------------------------------------------





