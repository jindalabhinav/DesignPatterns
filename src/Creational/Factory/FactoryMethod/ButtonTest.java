package Creational.Factory.FactoryMethod;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ButtonTest {

    @Test
    void testRoundButton() {
        // In a real world scenario, using Spring, this will use Conditional Dependency Injection -> using @Qualifier
        ButtonFactory buttonFactory = new RoundButtonFactory();
        Button button = buttonFactory.createButton(10.0, 1.0, null);
        assertTrue(button instanceof RoundBtn, "The button should be a round button");

    }

    @Test
    void testSquareButton() {
        // In a real world scenario, using Spring, this will use Conditional Dependency Injection -> using @Qualifier
        ButtonFactory buttonFactory = new SquareButtonFactory();
        Button button = buttonFactory.createButton(10.0, null, 1.0);
        assertTrue(button instanceof SquareButton, "The button should be a square button");

    }
}

/*
    WHY the Factory Pattern?
    1. SRP and OCP ==> Done (adding more products doesn't require changing the Factory if-else logic, instead, a new Concrete Factory class will be implemented for the new Product)
    2. Complex construction logic ==> Done (Factory class will be injected)
    3. Reduce usage of Subclasses ==> Done (now if library changes the class name of RoundBtn to RoundButton,
    client-code of construction won't break)

    Issues still existing?
    1. Class Explosion
    2. SRP and OCP violation resolved
*/