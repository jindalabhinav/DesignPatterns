package AbstractFactory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ThemeFactoryTest {

    @Test
    public void testDarkTheme() {
        // With this factory of factory, it's enforeced that wer get black theme components
        LightThemeFactory lightThemeFactory = new LightThemeFactory();

        Button button = lightThemeFactory.createButton(0.5, 10.0, 5.0);
        assertTrue(button instanceof LightButton, "If using a dark theme, tyhe button should be a dark button");

        Radio radio = lightThemeFactory.createRadio();
        assertTrue(radio instanceof LightRadio, "If using a dark theme, tyhe radio should be a dark button");
    }
}
