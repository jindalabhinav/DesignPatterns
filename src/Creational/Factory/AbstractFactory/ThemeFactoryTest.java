package Creational.Factory.AbstractFactory;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ThemeFactoryTest {

    @Test
    public void testLightTheme() {
        // With this factory of factory, it's enforeced that wer get black theme components
        ThemeFactory lightThemeFactory = new LightThemeFactory();

        Button button = lightThemeFactory.createButton(0.5, 10.0, 5.0);
        assertTrue(button instanceof LightButton, "If using a light theme, the button should be a light button");

        Radio radio = lightThemeFactory.createRadio();
        assertTrue(radio instanceof LightRadio, "If using a light theme, the radio should be a light radio");
    }
}
