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
    1. SRP and OCP ==> Done
    2. Complex construction logic ==> Done
    3. Reduce usage of Subclasses ==> Done (now if library changes the class name of RoundBtn to RoundButton, client-code of construction won't break)

    Issues still existing?
    1. Parameter Explosion (different kinds of products need different attributes, and we need to pass all of them to the factory)
        - Although, this is can be solved using Builder pattern
    2. SRP and OCP violation still persists, albeit on the library code
*/