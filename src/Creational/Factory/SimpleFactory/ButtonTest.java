package Creational.Factory.SimpleFactory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ButtonTest {

    @Test
    void testButton() {
        // With these implementations, if I change the name of the class to RoundButton and SquareButton respectively, the following code will break
        RoundBtn roundBtn = new RoundBtn(10.0, 1.0);
        SquareButton squareButton = new SquareButton(10.0, 1.0);
    }

    @Test
    void testRoundButton() {
        Button button = ButtonFactory.createButton(ScreenSize.PHONE, 10.0, 1.0, null);
        assertTrue(button instanceof RoundBtn, "If the screen size is of a phone, the btn should be a round button");

    }

    @Test
    void testSquareButton() {
        Button button = ButtonFactory.createButton(ScreenSize.DESKTOP, 10.0, null, 1.0);
        assertTrue(button instanceof SquareButton, "If the screen size is of a phone, the btn should be a square button");

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