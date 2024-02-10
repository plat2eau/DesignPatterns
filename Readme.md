# Design Patterns
Design patterns are typical solutions to common problems
in software design. Each pattern is like a blueprint
that you can customize to solve a particular
design problem in your code.

## Types
Design patterns are mainly classified into three types:

1. Creational
2. Structural
3. Behavioural

## Creational Design Patterns

Structural design patterns help manage the creation of objects

### Abstract Factory

### Builder
1. Helps in places where we have a lot of properties to be passed while object creation
2. Without it, we need to pass everything in constructor while remembering the order of the arguments
3. Creating objects with high number of properties without builder pattern will be cumbersome and difficult to read

### Factory
1. Help us manage the type of object that is created based on some criteria
2. Instead of defining that logic everywhere, we use factory to have that logic in one place
3. In future if that criteria changes, we only have the change factory logic

### Prototype
1. Useful at situations where we want to create a duplicate object without actually creating it again
2. Helps in cases where we do some DB calls to create an object by avoiding DB calls on every duplication

### Singleton
1. Only a single instance of a class is allowed
2. Techniques like double checked locking are used to improve performance.
3. Enum implementation is also for an easy implementation.

## Structural Design Patterns
Structural design patterns help manage the composition of the objects

### Adapter
1. Helps in places where we have a new system/ library that requires data in a different format than current system
2. Using adapter, no logic is needed to be changed in old system to communicate with the new system/ library

### Bridge

### Composite
1. When an object is containing multiple objects that have similar properties
2. Useful in places where we have a tree like structure or hierarchies

### Decorator

### Facade

### Flyweight

### Proxy
1. Used for controlling access to specific functionalities of a class.
2. Where allowed operations are dependent upon the role of the user.

## Behavioural Design Patterns
Structural design patterns help manage the interaction of the objects with each other

### Chain of Responsibility

### Command

### Interpreter

### Iterator

### Mediator

### Memento

### Observer
1. Used to observe changes happening in another object.
2. Useful in cases where pub-sub like logic needs to be implemented. 

### State

### Strategy

### Template Method

### Visitor