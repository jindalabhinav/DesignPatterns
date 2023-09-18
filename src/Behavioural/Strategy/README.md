# Strategy Pattern

## Analogies

### Google Maps

Let's say you're walking and use navigation to reach some place.

```Java
class Maps {
  navigate(x, y) {
    calculateDistance();
    calculateDurationOfWalking();
  }
}
```

Aaprt from walking, users might want to get Car, Bus, Train navigation as well.

```Java
Navigator {
  Mode mode; // enum

  navigate() {
    switch(mode) {
      BIKE:
      CAR:
      ......
    }
  }
}
```

This violates SRP, OCP. What's a better way to implement this?

Use inheritence,

Navigator

- Walk
- Car
- Bike

Now the use might switch between these different modes, inheritence won't help us here, it's unnecessary. The only thing changing is the input, for an input change, changing classes would be wasteful.

This is where we can use the *Strategy Abstraction*. It'll give us a way to use just 1 class but change strategies.

In out Navigator class, which implementation of the calss to put? Bike?Car?Walking?

That's why the implementation of the Navigator class should be abstract and the child class would decide.

We want to solve the problem of code duplication for different modews of transport (child classes of Navigator abstract class).

Let's create a Utility class NavigatorUtility and put all the common code there (navogateBudm, navigateCar, etc. and have the child class call them). But, this ends up violating SRP, because we end up putting anything and everything there. This is where strategy would help us. (using utility method, we'll have to change concrete implementation if the logic behind changes).

Tax Calculation (different algorithms)

- Olg regime
- New Regime

Strategy Pattern gives us a way to encapsulate different algorithms.

## Pre-requisite

### Dependency Injection

It's essentially dependency inversion. Whenever we want to implement dependency inversion, we use *Dependency Injection*.

Dependency Inversion - *high level modules should depend on other high level modules.*

Example:

Navigator class has different Algorithms,

- Bike
- Car
- Walk

Navigator class will have an Algorithm, and this allows us to pass Bike/Car/Walk algorithm to Navigator class (since Navigator HAS an Algorithm class object, you can initialize it with any child class).

```Java
// Construction Injection
var nav = new Navigator(new BikeAlgorithm()) // Dependency Injection using constructor (of Navigator)
.setStrategy();
```

## Implementation

Steps:

1. Strategy Interface

    It is the parent class of all algorithms.

    ```Java
    interface NavigationStrategy {
      Double navigate(A, B);
    }    
    ```

2. Concrete Strategies (Is-A relationship)

    ```Java
    // Two-wheeler
    // Car
    class ClassStrategy implements NavigationStrategy {

    }
    // Bus
    ```

3. Context Class (Has-A relationship)

    ```Java
    class Navigator {
      NavigatorStrategy strategy;

      Navigator(NavigatorStrategy strategy) {
        this.strategy = strategy;
      }

      navigate() {
        strategy.navigate();
      }
    }
    ```

4. Use Dependency Injection

    ```Java
    var nav = new Navigator(new CarSrategy());
    ```
