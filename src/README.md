# Design Patterns

## Types

1. Creational

   > All about Object creation.

    |   | SingleTon | Builder | Prototype | Factory |
    | - | --------- | ------- | --------- | ------- |
    | Why | Single Object<br> Inconsistencies<br> Resource Utilization | Too many fields, complex constructors<br> Immutability<br> Global Validation | Object creation is expensive<br> Create Multiple Objects | When you want to create multiple different type of objects<br> Not using Constructor of Child classes (tight-coupling) |
    | Examples | Redux Store, Connection Pool, Logging | Whenever you see a class having a lot of fields, like Address | Game Development | Different types of Buttons/Databases<br> Abstract - Darl/Light Buttons, Dark/Light Radio Button |
    | How | How: Lazy Initialization (Pros: creates object on demand, Cons: concurrency (need to implement thread safety)) |  | | Simple<br> 1. Product Interface<br> 2. Concrete Products<br> 3. Switch Case for Product Type (violates SRP, OCP) |
    |  | How: Eager Initialization (Pros: Thread-safety, Cons: creates object on Built time, increases time and load) | | | Factory Method<br> 1. Product Interface<br> 2. Concrete Products<br> 3. Factory IOnterface<br> 4. Concreate Factories<br> Class Explosion but solves SRP, OCP |
    |  | How: Double Check Logging | | | Abstract Factory (Family of Products)<br> 1. Product Interface<br> 2. Concrete Products<br> 3. Factory Interface (createButton(), createRadio())<br> 4.  |
    | Steps | Steps:<br> 1. constructor hiding<br> 2. getInstance()<br> 3. Instance attribute (static Initializer)<br> 4. Double safe (if created -> return else create, store, return)  | Steps:<br> 1. Static inner class<br> 2. private constructor<br> 3. Create reference of Outer object in Inner<br> 4. Fluent Setters for method Chaining<br> 5. Build Method (creates, validates and returns the object) | 1. Cloneable Interface<br> 2. Implementing Cloneable (clone method, shallow/deep clones)<br> 3. Create Registry (store object types in Registry) | |

2. Structural

   > How to structure your code.

   |   | Adaptor | Flyweight | Prototype | Decorator | Facade |
    | - | --------- | ------- | --------- | ------- | -------|
    | Why | Incompatible Interfaces<br> Uniform | Memory Impact (field value is duplicated and many objects)<br> Restricted to Memroy (specific), not concerned with CPU, Time Duration | Could be memory, cpu, time<br> Concerned with Creation of object not Duplication | Add Functionality but in a dynamic way without inheritence, without changing that class | When we have a lot of comples code, we just extract it to facade |
    | Example | Integration (Payment Integration, etc.) | Image in an object (bullet), Game-development and better memory utilization |  |  |  |
    | How | 0. Adaptor Interface (given, external interfaces)<br> 1, Adaptor Interface<br> 2. Concrete classes<br> 3.  | 1. Intrinsic (remains constant)<br> 2. Extrinsic(changing values)<br> 3. Extrinsic having reference to Intrinsic |  |  |  |

3. Behavioural

   > Communication, interaction between classes.

   |   | Observer | Strategy |
    | - | --------- | ------- |
    | Why | Publisher-Consumer<br> Event Driven | Encapsulation of your algorithm<br> Reduces Duplication, makes it flexible and reusable |
    | Example | Stocks, OrderManagement (push notification, state change), Form change, animations (something happens when you scroll) | Wherever there are multiple algos involved |
    | How | On change -> notify other classes<br> 1. Publisher Interface<br> 2. Consumer Interface<br> 3. Registry (Add, remove, notify) | Dependency Inversion and Injection<br> 1. Strategy interface<br> 2. Concrete classes<br> 3. Context class (has a start)<br> 4. ```new Context(new Strategy())``` |
