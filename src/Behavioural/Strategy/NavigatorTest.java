package Behavioural.Strategy;

import org.junit.jupiter.api.Test;

public class NavigatorTest {

    @Test
    public void testBullet() {
        // HSR to Indira Nagar
        NavigationStrategy strategy = new TwoWheelerStrategy();
        Navigator navigator = new Navigator(strategy); // Constructor Injection
        System.out.println(navigator.navigate("HSR", "Indira Nagar"));

        // Car
        NavigationStrategy carStrategy = new FourWheelerStrategy();
        navigator.setNavigationStrategy(carStrategy); // Method Injection, this is useful bcz we don't have to create another object now, just change the strategy
        System.out.println(navigator.navigate("HSR", "Indira Nagar"));
    }
}

// Bird
// Gliding, Flapping
// Eagle, Sparrow, Dove

// Eagle, Sparrow -> Gliding (code duplication for both type of birds)
// Dove -> Flapping

/* Solution:
    FlyingStrategy (interface) -> GlidingStrategy, FlappingStrategy (concrete classes)
    Eagle -> GlidingStrategy
    Sparrow -> FlappingStrategy
*/
